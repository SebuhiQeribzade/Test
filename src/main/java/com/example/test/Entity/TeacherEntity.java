package com.example.test.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name="/teacher")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    @Column(name = "name")
    private String name;
    @Column(name="age")
    private Integer age;
    @ManyToMany
    List<Student>students=new ArrayList<>();
}

