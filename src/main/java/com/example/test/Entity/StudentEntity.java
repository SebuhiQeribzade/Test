package com.example.test.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "/student")
@Entity
@Getter
@Setter
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name")
    private String name;
    @Column(name="age")
    private Integer age;
}
