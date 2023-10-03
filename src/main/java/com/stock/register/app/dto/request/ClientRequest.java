package com.stock.register.app.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

}
