package com.example.spring_security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * @created 05/07/2023 - 6:05 PM
 * @project Spring_Security
 * @author Yosef Adel Mahmoud Saaid
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class RequestValidationException extends RuntimeException{
    public RequestValidationException(String message) {
        super(message);
    }
}
