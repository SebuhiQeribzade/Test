package com.example.test.dto;

import com.example.test.Entity.Lesson;
import com.example.test.Entity.Teacher;
import lombok.Data;

import java.util.List;

@Data
public class StudentResponseDto {
    private Long id;
    private String name;
    private Integer age;
    List<Teacher> teacherList;
    List<Lesson> lessonList;
}
