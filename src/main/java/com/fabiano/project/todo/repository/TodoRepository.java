package com.fabiano.project.todo.repository;

import com.fabiano.project.todo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
