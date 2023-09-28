package com.stock.register.app;

import com.stock.register.app.rest.ClientRegisterResource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.isNotNull;

@SpringBootTest
class ClientRegisterResourceTest {

    @Autowired
    private ClientRegisterResource resource;
//
//    private ClientService clientService;
//
//    @BeforeEach
//    setup(){
//        this.clientService = mock(clientService);
//        this.resource = new ClientRegisterResource(clientService);
//    }

    @Test
    void resourceSuccessTest(){


        isNotNull();
    }

}
