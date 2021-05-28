package com.example.demo;

import java.util.List;
import java.util.NoSuchElementException;

import com.example.demo.errors.ConflictException;
import com.example.demo.errors.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    
    @Autowired
    private TodoReposetory todoReposetory;


    public List<Todomodel> findAll(){
        return todoReposetory.findAll();
    }

    public Todomodel findById(String id){
        try{
            return todoReposetory.findById(id).get();
        }catch (NoSuchElementException ex ){
            
            throw new NotFoundException(String.format("No Record with the id [%s] in our data base " , id ) );
        }
       
    }

    public Todomodel save(Todomodel todo){
        if(todoReposetory.findByTitle(todo.getTitle()) != null ){
            throw new ConflictException("Another title please ! ");
        }

        return todoReposetory.insert(todo);
    }

    public void delete(String id){ todoReposetory.deleteById(id);}
    
}
