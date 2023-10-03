package com.stock.register.app.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonPropertyOrder({
        "clientId",
        "fullName",
        "cpf",
        "birthDate",
        "activeRegister",
        "registrationDate",
        "lastUpdateDate"
})
public class ClientResponse {

    private String cpf;
    private Long clientId;
    private String fullName;
    private LocalDate birthDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registrationDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastUpdateDate;
    private Boolean activeRegister;
}
