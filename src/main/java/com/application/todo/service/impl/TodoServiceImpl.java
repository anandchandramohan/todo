package com.application.todo.service.impl;

import com.application.todo.entity.Todo;
import com.application.todo.repository.TodoRepository;
import com.application.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository repository;

    @Override
    public Todo create(Todo todo) {
        return repository.save(todo);
    }

    @Override
    public Todo update(Todo todo) {
        return repository.save(todo);
    }

    @Override
    public void delete(Long id) {
        repository.deleteByParentId(id);
        repository.deleteById(id);
    }
}
