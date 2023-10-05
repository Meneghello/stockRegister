package com.stock.register.cross;


public class BusinessException extends Exception{
    public BusinessException(String message) {
        super(message);
    }
    public BusinessException() {
        super();
    }
}
