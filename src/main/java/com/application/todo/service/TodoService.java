package com.application.todo.service;

import com.application.todo.entity.Todo;

import java.util.List;

public interface TodoService {
    Todo getTodo(String id);
    List<Todo> getAllTodo();
    Todo createTodo(Todo todo);
    Todo updateTodo(Todo todo);
    void deleteTodo(String id);
    Todo complete(String id);
}
