package com.application.todo.repository;

import com.application.todo.entity.TodoItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoItemRepository  extends CrudRepository<TodoItem, String> {

}
