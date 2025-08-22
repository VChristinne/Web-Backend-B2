package com.chris.demo.service;

import com.chris.demo.entity.Todo;
import java.util.List;


public interface TodoService {
    void save(Todo todo);
    void update(Todo todo);
    void delete(Long id);
    Todo findById(Long id);
    List<Todo> findAll();
}
