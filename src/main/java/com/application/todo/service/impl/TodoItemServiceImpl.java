package com.application.todo.service.impl;

import com.application.todo.entity.Todo;
import com.application.todo.entity.TodoItem;
import com.application.todo.repository.TodoItemRepository;
import com.application.todo.service.TodoItemService;
import com.application.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TodoItemServiceImpl implements TodoItemService {

    @Autowired
    private TodoItemRepository todoItemRepository;

    @Override
    public TodoItem getTodoItem(String id) {
       return todoItemRepository.findById(id).orElse(new TodoItem());
    }

    @Override
    public TodoItem createTodoItem(TodoItem todoItem) {
        todoItem.setCompleted(false);
        return todoItemRepository.save(todoItem);
    }

    @Override
    public TodoItem updateTodoItem(TodoItem todoItem) {
        return todoItemRepository.save(todoItem);
    }

    @Override
    public void deleteTodoItem(String id) {
        todoItemRepository.deleteById(id);
    }

    @Override
    public TodoItem complete(String id) {
        Optional<TodoItem> optional = todoItemRepository.findById(id);
        if(optional.isPresent()) {
            TodoItem todoItem = optional.get();
            if(todoItem.isCompleted() == true) {
                todoItem.setCompleted(false);
            } else {
                todoItem.setCompleted(true);
            }
            return todoItemRepository.save(todoItem);
        } else {
            return new TodoItem();
        }
    }
}
