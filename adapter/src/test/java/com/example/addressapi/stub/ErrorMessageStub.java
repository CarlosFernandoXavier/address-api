package com.example.addressapi.stub;

import com.example.addressapi.inbound.exception.ErrorMessage;
import org.springframework.http.HttpStatus;

public class ErrorMessageStub {

    public static ErrorMessage getErrorMessageBusinessException(){
        return ErrorMessage.builder()
                .status(HttpStatus.PRECONDITION_FAILED)
                .message("Erro")
                .url("/v1/get-address")
                .build();
    }
}
