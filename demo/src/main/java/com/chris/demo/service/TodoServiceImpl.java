package com.chris.demo.service;

import com.chris.demo.entity.Todo;
import com.chris.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@Transactional
public class TodoServiceImpl implements TodoService {

    private final TodoRepository repository;

    @Autowired
    public TodoServiceImpl(TodoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Todo todo) {
        repository.save(todo);
    }

    @Override
    public void update(Todo todo) {
        repository.save(todo);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public Todo findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Todo> findAll() {
        return repository.findAll();
    }
}

