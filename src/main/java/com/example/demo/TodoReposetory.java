package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoReposetory extends MongoRepository<Todomodel, String> {

    Todomodel findByTitle(String title);
}
