package com.chris.tasks.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate dueDate;
    private String responsible;

    public Task() {}

    public Task(
        String name, LocalDate dueDate, String responsible) {
        this.name = name;
        this.dueDate = dueDate;
        this.responsible = responsible;
    }
}