package com.stock.register.domain.assembler;

import com.stock.register.app.dto.request.ClientRequest;
import com.stock.register.app.dto.response.ClientResponse;
import com.stock.register.infra.db.StockClient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {

    @Mapping(source = "clientCpf", target = "cpf")
    @Mapping(source = "birthDate", target = "birthDate")
    @Mapping(source = "registrationDate", target = "registrationDate")
    @Mapping(source = "lastUpdateDate", target = "lastUpdateDate")
    @Mapping(source = "activeRegister", target = "activeRegister")
    @Mapping(source = "clientId", target = "clientId")
    @Mapping(expression = "java(stockClient.getName()  + \" \" +  stockClient.getSecondName())", target = "fullName")
    ClientResponse entityToResponse(StockClient stockClient);

    @Mapping(source = "request.name", target = "name")
    @Mapping(source = "request.secondName", target = "secondName")
    @Mapping(source = "request.cpf", target = "clientCpf")
    @Mapping(source = "request.birthDate", target = "birthDate")
    @Mapping(constant = "true", target = "activeRegister")
    @Mapping(expression = "java(Long.valueOf(sequence))", target = "clientId")
    @Mapping(expression = "java(java.util.UUID.randomUUID().toString())", target = "walletId")
    @Mapping(constant = "0.00", target = "totalAccountValue")
    StockClient requestToEntity(ClientRequest request, String sequence);

}
