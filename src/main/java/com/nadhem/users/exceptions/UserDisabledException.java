package com.nadhem.users.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UserDisabledException extends RuntimeException{
    private String message;

    public UserDisabledException(String message){
        super(message);
    }
}
