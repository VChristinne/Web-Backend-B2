package com.chris.demo.controller;

import com.chris.demo.entity.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/todos")
public class TodoController {

    List<Todo> todos = new ArrayList<>();

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("todo", new Todo());
        return "/todos/register";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Todo todo) {
        if (todo.getId() == null) {
            Long id = todos.size() + 1L;
            todo.setId(id);
            todos.add(todo);
        } else {
            for (Todo t : todos) {
                if (t.getId().equals(todo.getId())) {
                    t.setTitle(todo.getTitle());
                    t.setDueDate(todo.getDueDate());
                    t.setResponsible(todo.getResponsible());
                    return "redirect:/todos/list";
                }
            }
            todos.add(todo);
        }
        return "redirect:/todos/list";
    }

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("/todos/list");
        mv.addObject("todos", todos);
        return mv;
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Todo todo = todos.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (todo == null) {
            return "redirect:/todos/list";
        }
        model.addAttribute("todo", todo);
        return "/todos/register";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute Todo todo) {
        todos.stream()
                .filter(t -> t.getId().equals(todo.getId()))
                .findFirst()
                .ifPresent(t -> {
                    t.setTitle(todo.getTitle());
                    t.setDueDate(todo.getDueDate());
                    t.setResponsible(todo.getResponsible());
                });
        return "redirect:/todos/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        todos.removeIf(t -> t.getId().equals(id));
        return "redirect:/todos/list";
    }
}
