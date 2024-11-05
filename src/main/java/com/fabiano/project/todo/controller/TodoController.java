package com.fabiano.project.todo.controller;

import com.fabiano.project.todo.domain.Todo;
import com.fabiano.project.todo.dto.RequestTodoDTO;
import com.fabiano.project.todo.dto.RequestUpdateTodoDTO;
import com.fabiano.project.todo.dto.ResponseTodoDTO;
import com.fabiano.project.todo.repository.TodoRepository;
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
    public void updateTodo(@RequestBody RequestUpdateTodoDTO data){
        var id = this.todoRepository.findById(data.id());
        if(id.isPresent()){
            Todo dataTodo = new Todo(data);
            this.todoRepository.save(dataTodo);
            return;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable("id") Long id){
        this.todoRepository.deleteById(id);
        return;
    }
}
