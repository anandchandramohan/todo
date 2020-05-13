package com.application.todo.service;

import com.application.todo.entity.Todo;

public interface TodoService {
    Todo create(Todo todo);
    Todo update(Todo todo);
    void delete(Long id);
}
