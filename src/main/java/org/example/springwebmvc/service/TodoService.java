package org.example.springwebmvc.service;

import org.example.springwebmvc.model.Todo;

import java.util.List;

public interface TodoService {
    public List<Todo> getAllTodo();
    public Todo getTodoById (int id);
    public void addTodo(Todo todo);
    public void updateTodo(Todo todo);
    public void deleteTodo(int id);
    public List<Todo> checkUrl(String task,Boolean isDone);
    public List<Todo> searchTodos(String task, boolean isDone);

}
