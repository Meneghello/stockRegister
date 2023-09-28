package com.stock.register.cross;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum MessageCode {

    RS000("SC000", "Success"),
    RS001("SC001", "Client Success Create");


    final String messageId;
    final String message;

    MessageCode(String messageCode, String message){
        this.message = message;
        this.messageId = messageCode;
    }

    public static MessageCode getByMessageCode(String messageCode){
        return Stream.of(values()).filter(code -> code.messageId.equals(messageCode)).findFirst().orElseThrow();
    }
}
