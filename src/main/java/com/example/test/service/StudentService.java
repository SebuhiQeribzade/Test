package com.example.test.service;

import com.example.test.dto.StudentDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class StudentService {
List<StudentDto>studentDtos= new ArrayList<>();
public List<StudentDto> getAll() {
    return studentDtos;
}
public String create(@RequestBody StudentDto studentDto) {
    studentDtos.add(studentDto);
    return "Student added successfully" ;
}
public String delete(@RequestParam Long studentId) {
    studentDtos.removeIf(item -> Objects.equals(item.getId(), studentId));
    return "Student deleted successfully" ;
}
@PutMapping("/update{id}")
    public String update(@PathVariable Long id, @RequestBody StudentDto studentDto) {
    for (StudentDto item : studentDtos) {
        if (item.getId().equals(id)){
            item.builder()
                    .id(studentDto.getId())
                    .name(studentDto.getName())
                    .age(studentDto.getAge())
                    .build;
        }
    }
    return "Student updated successfully" ;
}
}
