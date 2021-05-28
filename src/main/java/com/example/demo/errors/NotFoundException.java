package com.example.demo.errors;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ApiBaseExceptions {

    public NotFoundException(String message){
        super(message);
    }
    

    public HttpStatus getStatusCode(){
        return HttpStatus.NOT_FOUND;
    } 
}
