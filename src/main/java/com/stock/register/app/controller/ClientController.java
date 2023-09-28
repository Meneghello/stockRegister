package com.stock.register.app.controller;

import com.stock.register.app.dto.request.ClientRequest;
import com.stock.register.cross.MessageCode;
import com.stock.register.domain.usecase.CreateClientUseCase;
import com.stock.register.domain.usecase.GetClientUseCase;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ClientController {

    private final GetClientUseCase getAllClientUseCase;

    private final CreateClientUseCase createClientUseCase;

    private final ResponseController responseController;

    public ClientController(GetClientUseCase getAllClientUseCase, CreateClientUseCase createClientUseCase, ResponseController responseController) {
        this.getAllClientUseCase = getAllClientUseCase;
        this.createClientUseCase = createClientUseCase;
        this.responseController = responseController;
    }

    public ResponseEntity<?> listAll() {
        return responseController.toResponse(getAllClientUseCase.getAll(), MessageCode.RS000);

    }

    public ResponseEntity<?> createClient(ClientRequest request) {
        log.info("Calling persisting flux");
        createClientUseCase.saveClient(request);
        return responseController.toResponse(null,MessageCode.RS001);
    }

    public ResponseEntity<?>  getClient(String cpf) {
        Long validatedCpf = getAllClientUseCase.validateCpf(cpf);
        responseController.toResponse(getAllClientUseCase.getByCpf(validatedCpf), MessageCode.RS000);
    }
//
//    public void createClient(ClientRequest request) {
//    }
}
