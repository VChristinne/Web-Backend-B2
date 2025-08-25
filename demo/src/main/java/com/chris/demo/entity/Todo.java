package com.chris.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@ToString(callSuper = true)
@Table(name="todos")
public class Todo extends AbstractEntity<Long> {

    @Column(name="title", nullable=false, unique=true, length=60)
    @NotBlank(message="{todo.title.notBlank}")
    @Size(min=5, max=60, message="{todo.title.size}")
    private String title;

    @Column(name="due_date", nullable=false, columnDefinition="DATE")
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    @NotNull(message="{todo.dueDate.notNull}")
    private LocalDate dueDate;

    @Column(name="responsible", nullable=false, length=60)
    @NotBlank(message="{todo.responsible.notBlank}")
    @Size(min=5, max=60, message="{todo.responsible.size}")
    private String responsible;
}
