package com.application.todo.controller;

import com.application.todo.entity.Todo;
import com.application.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {

    @Autowired
    private TodoService service;

    @PostMapping("/todo")
    public Todo addTodo(@RequestBody Todo todo) {
        return service.create(todo);
    }

    @PutMapping("/todo")
    public Todo modifyTodo(@RequestBody Todo todo) {
        return service.update(todo);
    }

    @DeleteMapping("/todo/{id}")
    public void deleteTodo(@PathVariable("id") Long id) {
        service.delete(id);
    }

}
