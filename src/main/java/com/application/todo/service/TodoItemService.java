package com.application.todo.service;

import com.application.todo.entity.TodoItem;

import java.util.List;

public interface TodoItemService {
   TodoItem getTodoItem(String id);
   TodoItem createTodoItem(TodoItem todoItem);
   TodoItem updateTodoItem(TodoItem todoItem);
   void deleteTodoItem(String id);
   TodoItem complete(String id);
}
