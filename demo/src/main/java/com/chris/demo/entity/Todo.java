package com.chris.demo.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;


@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Todo {

    private Long id;
    private String title;
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) private LocalDate dueDate;
    private String responsible;
}
