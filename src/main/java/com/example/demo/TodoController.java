package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/todo")
public class TodoController {

    @Autowired
    private TodoReposetory todoReposetory;

    @GetMapping
    public List<Todomodel> getAll() {

        return todoReposetory.findAll();
    }

    @PostMapping
    public Todomodel addone(@RequestBody Todomodel todo) {

        return todoReposetory.insert(todo);
    }

    // @PutMapping
    // public Todomodel updateOne(@RequestBody Todomodel todo){

    // return todoReposetory
    // }

}
