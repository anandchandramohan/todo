package com.application.todo.service.impl;

import com.application.todo.entity.Todo;
import com.application.todo.repository.TodoRepository;
import com.application.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Todo getTodo(String id) {
        return todoRepository.findById(id).orElse(new Todo());
    }

    @Override
    public List<Todo> getAllTodo() {
        return todoRepository.findAll();
    }

    @Override
    public Todo createTodo(Todo todo) {
        todo.setCompleted(false);
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(String id) {
        todoRepository.deleteById(id);
    }

    @Override
    public Todo complete(String id) {
        Optional<Todo> optional = todoRepository.findById(id);
        if(optional.isPresent()) {
            Todo todo = optional.get();
            if(todo.isCompleted() == true) {
                todo.setCompleted(false);
            } else {
                todo.setCompleted(true);
            }
            return todoRepository.save(todo);
        } else {
            return new Todo();
        }
    }
}
