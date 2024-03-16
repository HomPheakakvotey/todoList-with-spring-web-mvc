package org.example.springwebmvc.repository;

import lombok.Data;
import lombok.Getter;
import org.example.springwebmvc.model.Todo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
@Configuration
public class TodoListDatasource {
    @Bean
    public  List<Todo> todo (){
         return new ArrayList<>(){
             {
                 add(new Todo(1, "Homework", "Create Spring Project", true, LocalDate.now()));
                 add(new Todo(2, "Assignment", "Static website with NextJS", false, LocalDate.now()));
                 add(new Todo(3, "Watch Spring Video", "Watch from youtube", false, LocalDate.now()));
                 add(new Todo(4, "Wash Clothes", "Uniform", true, LocalDate.now()));
                 add(new Todo(5, "Quiz", "Spring", false, LocalDate.now()));
             }};
        }

}
