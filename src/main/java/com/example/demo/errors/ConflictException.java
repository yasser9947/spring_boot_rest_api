package com.example.demo.errors;

import org.springframework.http.HttpStatus;

public class ConflictException extends ApiBaseExceptions{


    public ConflictException (String message){
        super(message);
    }
    @Override
    public HttpStatus getStatusCode(){
        return HttpStatus.CONFLICT;
    }
    
}
