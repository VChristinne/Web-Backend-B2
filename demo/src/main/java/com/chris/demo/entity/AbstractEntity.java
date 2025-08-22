package com.chris.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@MappedSuperclass
public class AbstractEntity <ID extends Serializable> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;
}
