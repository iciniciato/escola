package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ImpossivelExcluir extends ResponseStatusException {

    public ImpossivelExcluir(String errorMessage) {
        super(HttpStatus.BAD_REQUEST, errorMessage);
    }
}
