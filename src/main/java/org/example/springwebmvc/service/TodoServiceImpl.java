package org.example.springwebmvc.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.springwebmvc.model.Todo;
import org.example.springwebmvc.repository.TodoListDatasource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
    private final List<Todo> todos;
    @Override
    public List<Todo> getAllTodo() {
       return todos;
    }

    @Override
    public Todo getTodoById(int id) {
        return todos.stream().filter(todo -> todo.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public void addTodo(Todo todo) {
        todo.setCreatedAt(LocalDate.now());
        todos.add(todo);
    }

    @Override
    public void updateTodo(Todo todo) {
        todo.setCreatedAt(LocalDate.now());
        todos.stream().filter(t -> t.getId() == todo.getId())
                .findFirst()
                .ifPresentOrElse(
                        t -> {
                            int index = todos.indexOf(t);
                            todos.set(index, todo);
                        },
                        () -> {
                            throw new IllegalArgumentException("Todo with ID " + todo.getId() + " not found");
                        });
    }

    @Override
    public void deleteTodo(int id) {
        todos.removeIf(d -> d.getId() == id);
    }

    @Override
    public List<Todo> checkUrl(String task, Boolean isDone) {
        if (task != null && !task.isEmpty()) {
            if (isDone != null) {
                return searchTodos(task, isDone);
            } else {
                return  searchTodos(task,false);
            }
        } else {
            return getAllTodo();
        }
    }

    @Override
    public List<Todo> searchTodos(String task, boolean isDone) {
        return todos.stream().filter(todo-> todo.getTask().contains(task) && todo.isDone() == isDone)
                .collect(Collectors.toList());
    }




}
