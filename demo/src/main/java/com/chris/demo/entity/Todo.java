package com.chris.demo.entity;

import lombok.*;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@ToString(callSuper = true)
@Table(name="todos")
public class Todo extends AbstractEntity<Long> {

    @Column(name="title", nullable = false, unique = true, length = 60)
    private String title;

    @Column(name="due_date", nullable = false, columnDefinition = "DATE")
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDate dueDate;

    @Column(name="responsible", nullable = false, length = 60)
    private String responsible;
}
