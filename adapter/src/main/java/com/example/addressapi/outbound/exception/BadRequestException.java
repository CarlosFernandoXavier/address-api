package com.example.addressapi.outbound.exception;

public class BadRequestException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "incorrect zipcode";

    public BadRequestException() {
        super(DEFAULT_MESSAGE);
    }
}

