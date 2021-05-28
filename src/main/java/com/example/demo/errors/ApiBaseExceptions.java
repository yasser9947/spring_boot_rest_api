package com.example.demo.errors;

import org.springframework.http.HttpStatus;

public abstract class ApiBaseExceptions  extends RuntimeException{

    public ApiBaseExceptions(String message){
        super(message);
    }

    public abstract HttpStatus getStatusCode();
    
}
