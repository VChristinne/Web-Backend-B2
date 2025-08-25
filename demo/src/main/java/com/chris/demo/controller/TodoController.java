package com.chris.demo.controller;

import com.chris.demo.entity.Todo;
import com.chris.demo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("todos", todoService.findAll());
        return "todos/list";
    }

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("todo", new Todo());
        return "todos/form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model, RedirectAttributes attrs) {
        Todo todo = todoService.findById(id);
        if (todo == null) {
            attrs.addFlashAttribute("message", "Todo not found");
            return "redirect:/todos/list";
        }
        model.addAttribute("todo", todo);
        return "todos/form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Todo todo, BindingResult result, RedirectAttributes attrs) {
        if (result.hasErrors()) {
            return "todos/form";
        }

        boolean isNew = todo.getId() == null;

        if (isNew) {
            todoService.save(todo);
            attrs.addFlashAttribute("message", "Todo created successfully!");
        } else {
            todoService.update(todo);
            attrs.addFlashAttribute("message", "Todo updated successfully!");
        }
        return "redirect:/todos/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes attrs) {
        try {
            todoService.delete(id);
            attrs.addFlashAttribute("message", "Todo removed successfully!");
        } catch (Exception e) {
            attrs.addFlashAttribute("error", "Error removing: " + e.getMessage());
        }
        return "redirect:/todos/list";
    }
}
