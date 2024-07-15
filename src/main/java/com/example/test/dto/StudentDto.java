package com.example.test.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StudentDto {
    private Long id;
    private String name;
    private int age;
}
