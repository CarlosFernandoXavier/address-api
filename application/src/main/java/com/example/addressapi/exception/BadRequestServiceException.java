package com.example.addressapi.exception;

public class BadRequestServiceException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "CEP incorreto";
    public BadRequestServiceException(String message) {
        super(message);
    }
    public BadRequestServiceException() {
        super(DEFAULT_MESSAGE);
    }
}

