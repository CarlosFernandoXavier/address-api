package com.example.addressapi.outbound.exception;

public class BadRequestException  extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "CEP incorreto";
    public BadRequestException(String message) {
        super(message);
    }
    public BadRequestException() {
        super(DEFAULT_MESSAGE);
    }
}

