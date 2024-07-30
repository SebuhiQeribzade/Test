package com.example.test.dto.response;

import com.example.test.Entity.Lesson;
import com.example.test.Entity.Teacher;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentResponseDto {
    private Long id;
    private String name;
    private Integer age;
    List<Teacher> teacherList;
    List<Lesson> lessonList;
}
