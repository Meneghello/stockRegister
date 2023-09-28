package com.stock.register.app.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Getter
@Setter
public class ClientRequest {

    @NotNull
    private String name;
    private String secondName;
    @NotNull
    @CPF
    private String cpf;
    @NotNull
    private LocalDate birthDate;

}
