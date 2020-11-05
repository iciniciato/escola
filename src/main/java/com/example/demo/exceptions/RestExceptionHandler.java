package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({ImpossivelExcluir.class})
    public ResponseEntity impossivelExcluirHandle(ImpossivelExcluir impossivelExcluir) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(impossivelExcluir.getMessage());
    }
}