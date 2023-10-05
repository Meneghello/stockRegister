package com.stock.register.app.rest;

import com.stock.register.app.controller.ClientController;
import com.stock.register.app.dto.request.ClientRequest;
import com.stock.register.cross.BusinessException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/v1/client")
@RestController
public class ClientRegisterResource {

    private final ClientController service;

    public ClientRegisterResource(ClientController service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> listAllClients(@RequestParam(value = "CPF", required = false) String cpf) {
        if (cpf!=null){
            return service.getClient(cpf);
        }
        return service.listAll();
    }
    @PostMapping
    public ResponseEntity<?> createClient(@RequestBody @Valid  ClientRequest request) throws BusinessException {
        return service.createClient(request);
    }

}
