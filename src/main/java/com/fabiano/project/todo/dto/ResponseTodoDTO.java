package com.fabiano.project.todo.dto;

import com.fabiano.project.todo.domain.Todo;

public record ResponseTodoDTO(Long id, String title, String message, String priority) {

    public ResponseTodoDTO(Todo todo){
        this(todo.getId(), todo.getTitle(), todo.getMessage(), String.valueOf(todo.getPriority()));
    }
}
