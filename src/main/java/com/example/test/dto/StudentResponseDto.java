package com.example.test.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class StudentResponseDto {
    private Long id;
    private String name;
    private Integer age;
}
