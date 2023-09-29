package com.stock.register.domain.usecase;

import com.stock.register.app.dto.response.ClientResponse;
import com.stock.register.cross.BusinessException;
import com.stock.register.domain.assembler.ClientMapper;
import com.stock.register.infra.db.StockClient;
import com.stock.register.infra.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@Component
@Log4j2
public class GetClientUseCase {
    private final ClientRepository repository;
    private final ClientMapper mapper;


    public GetClientUseCase(ClientRepository repository, ClientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public List<ClientResponse> getAll() {
        List<ClientResponse> list = new ArrayList<>();
        List<StockClient> repositoryResult = repository.findAll();
        if(repositoryResult.isEmpty()) {
            log.info("::getByCpf() -> Empty client List");
            throw new ArrayIndexOutOfBoundsException();
        }
        repositoryResult.forEach(entity ->
                list.add(mapper.entityToResponse(entity))
        );
        log.info("::getByCpf() -> Returning client list");
        return list;
    }

    public ClientResponse getByCpf(Long cpf) {
        StockClient result = repository.findById(cpf).orElseThrow(() -> new EntityNotFoundException(cpf.toString()));
        log.info("::getByCpf() -> Client found");
        return mapper.entityToResponse(result);
    }

    public Long validateCpf(String cpf) {
        try{
            log.info("::validateCpf() -> Starting validating CPF -> {}",cpf);
            return Long.parseLong(cpf);
        } catch (Exception e){
            throw new NumberFormatException("Format of CPF is invalid");
        }
    }
}
