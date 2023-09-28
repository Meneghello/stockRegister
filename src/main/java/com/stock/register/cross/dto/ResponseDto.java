package com.stock.register.cross.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({"status", "result"})
public class ResponseDto<T> {

    private Status status;
    private T result;

}
