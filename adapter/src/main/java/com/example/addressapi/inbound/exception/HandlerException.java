package com.example.addressapi.inbound.exception;

import com.example.addressapi.outbound.exception.BadRequestException;
import com.example.addressapi.outbound.exception.BusinessException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class HandlerException {

    private final MessageSource source;

    public HandlerException(final MessageSource messageSource) {
        source = messageSource;
    }

    @ExceptionHandler(value = {BusinessException.class})
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    @ResponseBody
    public ErrorMessage handleResponseStatusException(final BusinessException ex, WebRequest request) {
        String path = getPath(request.getDescription(false));

        return new ErrorMessage(HttpStatus.PRECONDITION_FAILED, "message", path);
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorMessage handleException(final Exception ex, WebRequest request) {
        String path = getPath(request.getDescription(false));
        final String message = ex.getMessage();
        return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, message, path);
    }

    @ExceptionHandler(value = {BadRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage handleBadRequestException(final BadRequestException ex, WebRequest request) {
        String path = getPath(request.getDescription(false));
        final String message = ex.getMessage();
        return new ErrorMessage(HttpStatus.BAD_REQUEST, message, path);
    }

    private String getPath(String path) {
        return path.replace("uri=", "");
    }

}
