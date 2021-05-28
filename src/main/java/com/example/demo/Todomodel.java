package com.example.demo;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import ch.qos.logback.core.joran.spi.NoAutoStart;

@Document(collection = "todo")
public class Todomodel {

    /**
     *
     */


    @Id
    private String id;
    
    @NotNull(message = "can not be null")
    @Size(min = 3 , message = "can not be negative")
    private String title;


    private String description;
    private long timestamp;

    public Todomodel() {
        this.timestamp = System.currentTimeMillis();
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Todomodel(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
