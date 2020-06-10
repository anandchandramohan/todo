package com.application.todo.controller;

import com.application.todo.entity.Todo;
import com.application.todo.repository.TodoRepository;
import com.application.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return todoService.getAllTodo();
    }

    @GetMapping("/todos/{id}")
    public Todo getTodo(@PathVariable("id") String id) {
        return todoService.getTodo(id);
    }

    @PostMapping("/todo")
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    @PutMapping("/todo")
    public Todo updateTodo(@RequestBody Todo todo) {
        return todoService.updateTodo(todo);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable("id") String id) {
         todoService.deleteTodo(id);
    }

    @PutMapping("/todos/{id}/toggle_complete_status")
    public Todo changeCompleteStatus(@PathVariable("id") String id) {
        return todoService.complete(id);
    }
}
