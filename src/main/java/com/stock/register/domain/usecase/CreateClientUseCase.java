package com.stock.register.domain.usecase;

import com.stock.register.app.dto.request.ClientRequest;
import com.stock.register.domain.assembler.ClientMapper;
import com.stock.register.infra.db.StockClient;
import com.stock.register.infra.repository.ClientRepository;
import jakarta.persistence.EntityManager;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class CreateClientUseCase {

    private final EntityManager entityManager;
    private final ClientMapper mapper;

    public CreateClientUseCase(EntityManager entityManager, ClientMapper mapper) {
        this.entityManager = entityManager;
        this.mapper = mapper;
    }

    public void saveClient(ClientRequest request) {
        log.info("Starting persisting");
        StockClient entity = mapper.requestToEntity(request);
        entityManager.persist(entity);
        log.info("Persist complete");
    }
}
