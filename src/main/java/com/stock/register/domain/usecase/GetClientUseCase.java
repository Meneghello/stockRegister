package com.stock.register.domain.usecase;

import com.stock.register.app.dto.response.ClientResponse;
import com.stock.register.domain.assembler.ClientMapper;
import com.stock.register.infra.repository.ClientRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetClientUseCase {
    private final ClientRepository repository;
    private final ClientMapper mapper;


    public GetClientUseCase(ClientRepository repository, ClientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public List<ClientResponse> getAll() {
        List<ClientResponse> list = new ArrayList<>();
        repository.findAll().forEach(entity ->
                list.add(mapper.entityToResponse(entity))
        );
        return list;
    }

    public ClientResponse getByCpf(Long cpf) {
        return mapper.entityToResponse(repository.findById(cpf));
    }

    public Long validateCpf(String cpf) {
        try{
            return Long.parseLong(cpf);
        } catch (Exception){
            throw new
        }
    }
}
