package com.springboot.Responses;

import org.springframework.http.HttpStatus;

public class CFMSException extends RuntimeException{

    private HttpStatus httpStatus;

    public CFMSException(String message) {
        super(message);
    }

    public CFMSException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

}
