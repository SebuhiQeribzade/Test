package com.example.test.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentRequestDto {
    private String name;
    private Integer age;
    private List<Long> teacherIds;
    private List<Long> lessonIds;

}
