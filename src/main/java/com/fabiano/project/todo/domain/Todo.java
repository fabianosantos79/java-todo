package com.fabiano.project.todo.domain;

import com.fabiano.project.todo.dto.RequestTodoDTO;
import com.fabiano.project.todo.dto.ResponseTodoDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "todos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    @Enumerated(EnumType.STRING)
    private Priority priority;

    public Todo(ResponseTodoDTO data){
        this.title = data.title();
        this.message = data.message();
        this.priority = Priority.valueOf(data.priority());
    }

    public Todo(RequestTodoDTO data) {
        this.title = data.title();
        this.message = data.message();
        this.priority = Priority.valueOf(data.priority());
    }
}
