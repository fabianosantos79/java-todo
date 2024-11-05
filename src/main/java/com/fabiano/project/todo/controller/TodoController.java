package com.fabiano.project.todo.controller;

import com.fabiano.project.todo.domain.Todo;
import com.fabiano.project.todo.dto.RequestTodoDTO;
import com.fabiano.project.todo.dto.ResponseTodoDTO;
import com.fabiano.project.todo.repository.TodoRepository;
import com.fabiano.project.todo.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todos")
public class TodoController {

    private TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @GetMapping
    public List<ResponseTodoDTO> listTodo(){
        List<ResponseTodoDTO> listResponse = this.todoRepository.findAll().stream().map(ResponseTodoDTO::new).toList();
        return listResponse;
    }

    @PostMapping
    public void createTodo(@RequestBody RequestTodoDTO data){
        Todo dataTodo = new Todo(data);
        this.todoRepository.save(dataTodo);
        return;
    }

    @PutMapping
    public void updateTodo(){

    }

    @DeleteMapping
    public void deleteTodo(){

    }
}
