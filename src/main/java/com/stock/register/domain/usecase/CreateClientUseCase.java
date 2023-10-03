package com.stock.register.domain.usecase;

import com.stock.register.app.dto.request.ClientRequest;
import com.stock.register.domain.assembler.ClientMapper;
import com.stock.register.infra.db.StockClient;
import com.stock.register.infra.repository.ClientRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Log4j2
public class CreateClientUseCase {

    private final EntityManager entityManager;
    private final ClientMapper mapper;

    public CreateClientUseCase(EntityManager entityManager, ClientMapper mapper, ClientRepository repository) {
        this.entityManager = entityManager;
        this.mapper = mapper;
    }

    @Transactional
    public void saveClient(ClientRequest request) {
        log.info("::saveClient() -> Starting persisting");
        StockClient entity = mapper.requestToEntity(request);

        log.info("::saveClient() -> Generating ids");
        String clientSequence = entityManager.createNativeQuery("SELECT nextval('client_client_id_seq')").getSingleResult().toString();
        String walletId = UUID.randomUUID().toString();

        entity.setWalletId(walletId);
        entity.setClientId(Long.valueOf(clientSequence));
        entityManager.persist(entity);
        log.info("::saveClient() -> Persistence complete");
    }


}
