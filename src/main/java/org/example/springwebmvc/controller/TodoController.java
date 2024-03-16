package org.example.springwebmvc.controller;

import lombok.RequiredArgsConstructor;
import org.example.springwebmvc.model.Todo;
import org.example.springwebmvc.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/todo")
    public String getTodo(Model model){
       model.addAttribute("todo",todoService.getAllTodo());
       return "index";
    }

    @GetMapping("/todo/{id}")
    public String getTodobyId(Model model, @PathVariable int id){
        Todo todo = todoService.getTodoById(id);
        model.addAttribute("todo",todo);
        return "todoid";
    }

    @GetMapping("/todo/new")
    public String newTodoForm(Model model){
        model.addAttribute("todo",new Todo());
        return "addForm";
    }

    @PostMapping("/todo/new")
    public String addTodo(@ModelAttribute Todo todo){
        todoService.addTodo(todo);
        return "redirect:/todo";
    }

    @GetMapping("/todo/edit/{id}")
    public String showEditTodoForm(@PathVariable int id, Model model) {
        Todo todo = todoService.getTodoById(id);
        model.addAttribute("todos", todo);
        return "edit";
    }

    @PostMapping("/todo/edit/{id}")
    public String editTodo(@PathVariable int id, @ModelAttribute Todo todo) {
        todo.setId(id);
        todoService.updateTodo(todo);
        return "redirect:/todo";
    }
    @GetMapping("/todo/delete/{id}")
    public String deleteTodo(@PathVariable int id) {
        todoService.deleteTodo(id);
        return "redirect:/todo";
    }

    @GetMapping("/todo/search")
    public String searchTodos(@RequestParam(required = false,defaultValue ="") String task,
                              @RequestParam(required = false) Boolean isDone,
                              Model model) {

        model.addAttribute("todo", todoService.checkUrl(task,isDone));
        return "index";
    }

}
