package com.stock.register.app.rest;

import com.stock.register.app.controller.ClientController;
import com.stock.register.app.dto.request.ClientRequest;
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

    @GetMapping()
    public ResponseEntity<?> listAllClients() {
        return service.listAll();
    }
//
//    @GetMapping(path = "/{cpf}")
//    private ResponseEntity<> listAllClients(@RequestParam(value = "cpf") String cpf) {
//        service.getClient(cpf);
//    }
//
    @PostMapping
    private ResponseEntity<?> createClient(@RequestBody @Valid  ClientRequest request) {
        return service.createClient(request);
    }

}
