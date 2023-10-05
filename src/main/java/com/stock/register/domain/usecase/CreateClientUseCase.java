package com.stock.register.domain.usecase;

import com.stock.register.app.dto.request.ClientRequest;
import com.stock.register.cross.BusinessException;
import com.stock.register.domain.assembler.ClientMapper;
import com.stock.register.infra.db.StockClient;
import com.stock.register.infra.repository.ClientRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

@Component
@Log4j2
public class CreateClientUseCase {

    private final EntityManager entityManager;
    private final ClientMapper mapper;
    private final ClientRepository repository;

    public CreateClientUseCase(EntityManager entityManager, ClientMapper mapper, ClientRepository repository) {
        this.entityManager = entityManager;
        this.mapper = mapper;
        this.repository = repository;
    }

    @Transactional
    public void saveClient(ClientRequest request) {
        log.info("::saveClient() -> Generating ids");
        String clientSequence = entityManager.createNativeQuery("SELECT nextval('client_client_id_seq')").getSingleResult().toString();

        log.info("::saveClient() -> Starting persisting");
        StockClient clientEntity = mapper.requestToEntity(request, clientSequence);


        entityManager.persist(clientEntity);
        log.info("::saveClient() -> Persistence complete");
    }


    public void validateUnique(String cpf) {
        repository.findById(Long.valueOf(cpf)).ifPresent(stockClient -> {
                    try {
                        throw new BusinessException();
                    } catch (BusinessException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }
}
