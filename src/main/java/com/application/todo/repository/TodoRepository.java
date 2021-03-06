package com.application.todo.repository;

import com.application.todo.entity.Todo;
import com.application.todo.entity.TodoItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, String> {
    List<Todo> findAll();
}
