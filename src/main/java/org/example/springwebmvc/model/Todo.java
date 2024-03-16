package org.example.springwebmvc.model;

import lombok.*;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    private int id;
    private String task;
    private String description;
    private boolean isDone;
    private LocalDate createdAt;


}
