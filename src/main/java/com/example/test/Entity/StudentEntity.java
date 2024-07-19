package com.example.test.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "/student")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name")
    private String name;
    @Column(name="age")
    private Integer age;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)

    private List<LessonEntity> lessonEntityList;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<TeacherEntity> teacherEntityList;
}
