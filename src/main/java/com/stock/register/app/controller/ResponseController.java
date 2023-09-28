package com.stock.register.app.controller;

import com.stock.register.app.dto.response.ClientResponse;
import com.stock.register.cross.MessageCode;
import com.stock.register.cross.dto.ResponseDto;
import com.stock.register.cross.dto.Status;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Log4j2
public class ResponseController<T> {
    public ResponseEntity<ResponseDto<T>> toResponse(T object, MessageCode messageId) {

        Status status = new Status();
        status.setMessage(messageId.getMessage());
        status.setMessageId(messageId.getMessageId());
        status.setTime(LocalDateTime.now());

        ResponseDto<T> responseDto = new ResponseDto<T>();
        responseDto.setStatus(status);
        responseDto.setResult(object);
        log.info("Flux finished with MessageId: {}",messageId.getMessageId());
        return ResponseEntity.ok().body(responseDto);
    }
}
