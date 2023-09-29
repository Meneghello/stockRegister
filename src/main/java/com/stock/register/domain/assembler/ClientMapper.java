package com.stock.register.domain.assembler;

import com.stock.register.app.dto.request.ClientRequest;
import com.stock.register.app.dto.response.ClientResponse;
import com.stock.register.infra.db.StockClient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {

    @Mapping(source = "cpf", target = "cpf")
    @Mapping(source = "birthDate", target = "birthDate")
    @Mapping(source = "registrationDate", target = "registrationDate")
    @Mapping(source = "lastUpdateDate", target = "lastUpdateDate")
    @Mapping(source = "activeRegister", target = "activeRegister")
    @Mapping(source = "clientId", target = "clientId")
    @Mapping(expression = "java(stockClient.getName()  + \" \" +  stockClient.getSecondName())", target = "fullName")
    ClientResponse entityToResponse(StockClient stockClient);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "secondName", target = "secondName")
    @Mapping(source = "cpf", target = "cpf")
    @Mapping(source = "birthDate", target = "birthDate")
    @Mapping(constant = "true", target = "activeRegister")
    StockClient requestToEntity(ClientRequest request);
}
