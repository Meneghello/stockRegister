package com.stock.register.app.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ClientResponse {

    private String cpf;
    private Long clientId;
    private String fullName;
    private LocalDate birthDate;
    private LocalDateTime registrationDate;
    private LocalDateTime lastUpdateDate;
    private Boolean activeRegister;
}
