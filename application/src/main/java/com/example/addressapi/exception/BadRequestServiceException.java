package com.example.addressapi.exception;

public class BadRequestServiceException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "incorrect zipcode";
    public BadRequestServiceException() {
        super(DEFAULT_MESSAGE);
    }
}

