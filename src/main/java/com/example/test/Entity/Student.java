package com.example.test.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "student")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name")
    private String name;
    @Column(name="age")
    private Integer age;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "students")
    private List<Lesson> lessonList;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "students")
    private List<TeacherEntity> teacherEntityList;
}
