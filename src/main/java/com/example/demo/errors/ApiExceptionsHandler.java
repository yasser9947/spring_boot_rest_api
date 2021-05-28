package com.example.demo.errors;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionsHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(ApiBaseExceptions.class)
    public ResponseEntity<ErrorDetails>  handleApiExceptions(ApiBaseExceptions ex , WebRequest request){

        ErrorDetails detilse = new ErrorDetails(ex.getMessage() , request.getDescription(false));
        return new ResponseEntity<>(detilse , ex.getStatusCode());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
                 
                ValidtionErors validationError = new ValidtionErors();
                validationError.setUri( request.getDescription(false));
                List<FieldError> filedErrors = ex.getBindingResult().getFieldErrors();
                for(FieldError f : filedErrors) {
                    validationError.addErrors(f.getDefaultMessage());
                }

        // TODO Auto-generated method stub
        return new ResponseEntity<>(validationError , HttpStatus.BAD_REQUEST);
    }



}
