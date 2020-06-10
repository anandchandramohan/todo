package com.application.todo.controller;

import com.application.todo.entity.TodoItem;
import com.application.todo.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoItemController {

    @Autowired
    private TodoItemService todoItemService;

    @GetMapping("/todo-items/{id}")
    public TodoItem getTodoItem(@PathVariable("id") String id) {
        return todoItemService.getTodoItem(id);
    }

    @PostMapping("/todo-item")
    public TodoItem addTodoItem(@RequestBody TodoItem todoItem) {
        return todoItemService.createTodoItem(todoItem);
    }

    @PutMapping("/todo-item")
    public TodoItem updateTodoItem(@RequestBody TodoItem todoItem) {
        return todoItemService.updateTodoItem(todoItem);
    }

    @DeleteMapping("/todo-items/{id}")
    public void deleteTodoItem(@PathVariable("id") String id) {
        todoItemService.deleteTodoItem(id);
    }

    @PutMapping("/todo-items/{id}/toggle_complete_status")
    public TodoItem changeCompleteStatus(@PathVariable("id") String id) {
        return todoItemService.complete(id);
    }
}
