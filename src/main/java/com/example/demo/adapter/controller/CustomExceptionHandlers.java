package com.example.demo.adapter.controller;

import com.example.demo.exception.TipoDeArquivoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandlers {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(TipoDeArquivoException.class)
    public Map<String, String> handle(TipoDeArquivoException ex) {
        Map<String, String> errors = new HashMap<>();
            String errorMessage = ex.getMessage();
            errors.put("cause", errorMessage);
        return errors;
    }

}
