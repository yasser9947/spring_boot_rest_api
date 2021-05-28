package com.example.demo.errors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ValidtionErors {

    private List<String> errors;
    private String uri; 

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy hh:mm:ss")
    private Date timestamp;
    ValidtionErors(){
        this.timestamp = new Date();
        this.errors = new ArrayList<String>();
    }


    public List<String> getErrors() {
        return errors;
    }


    public void setErrors(List<String> errors) {
        this.errors = errors;
    }


    public void addErrors(String error){
        this.errors.add(error);
    }


    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

}
