package com.example.demo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public ResponseEntity<List<Todomodel>> getAll() {

        return new ResponseEntity<List<Todomodel>>(todoService.findAll() ,HttpStatus.OK );
    }
    // get one 
    @GetMapping(value = "/{id}")
    public ResponseEntity<Todomodel> getOne(@PathVariable String id) {
        System.out.println(id);
        Todomodel result = todoService.findById(id);
        return new ResponseEntity<Todomodel>( result , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Todomodel> addone(@Valid @RequestBody  Todomodel todo) {

        return  new ResponseEntity<Todomodel>( todoService.save(todo) , HttpStatus.CREATED);
    }

    // @PutMapping
    // public Todomodel updateOne(@RequestBody Todomodel todo){

    // return todoService
    // }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteOne(@PathVariable String id){
        todoService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    } 

}
