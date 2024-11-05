package com.fabiano.project.todo.service;

import com.fabiano.project.todo.domain.Todo;
import com.fabiano.project.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> createTodo(Todo todo){
        this.todoRepository.save(todo);
        return listTodo();
    }

    public List<Todo> listTodo(){
        Sort sort = Sort.by("title");
        return this.todoRepository.findAll(sort);
    }

    public List<Todo> updateTodo(Todo todo){
        this.todoRepository.save(todo);
        return listTodo();
    }

    public List<Todo> deleteTodo(Long id){
        this.todoRepository.deleteById(id);
        return listTodo();
    }

}
