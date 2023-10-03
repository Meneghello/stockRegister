package com.stock.register.cross;

import com.stock.register.app.controller.ResponseController;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
    final ResponseController responseController;

    public ExceptionHandlerController(ResponseController responseController) {
        this.responseController = responseController;
    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> entityNotFoundHandler(EntityNotFoundException e) {
        return responseController.toResponse(null, MessageCode.constructMessageError(MessageCode.RS002, e.getMessage()));
    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    protected ResponseEntity<Object> emptyListHandler(ArrayIndexOutOfBoundsException e) {
        return responseController.toResponse(null, MessageCode.RS003);
    }
    @ExceptionHandler(NumberFormatException.class)
    protected ResponseEntity<Object> invalidCpf(NumberFormatException e) {
        return responseController.toResponse(null, MessageCode.RS004);
    }
}
