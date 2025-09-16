package com.example.common.exceptions;

import lombok.Getter;

@Getter

public class CustomException extends RuntimeException{
    private final String errorCode;

    public CustomException(String message, String errorCode){
        super(message);
        this.errorCode=errorCode;
    }
}
