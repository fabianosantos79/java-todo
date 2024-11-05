package com.fabiano.project.todo.dto;

public record RequestUpdateTodoDTO(Long id, String title, String message, String priority) {
}
