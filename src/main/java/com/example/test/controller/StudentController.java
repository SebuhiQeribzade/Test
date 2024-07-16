package com.example.test.controller;

import com.example.test.Entity.StudentEntity;
import com.example.test.dto.StudentRequestDto;
import com.example.test.dto.StudentResponseDto;
import com.example.test.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Student")

public class StudentController {

 private final StudentService studentService;
 public StudentController(StudentService studentService) {
     this.studentService = studentService;
 }

    @GetMapping("/getAll")
    public List<StudentResponseDto> getStudent(){
        return studentService.getAll();

    }
    @PostMapping("/create")
    public String createStudent(@RequestBody StudentRequestDto studentRequestDto){
    studentService.create(studentRequestDto);
    return "Student created";
    }
    @DeleteMapping("/delete")
    public String deleteStudent(@RequestBody StudentResponseDto studentResponseDto){
studentService.delete(studentResponseDto.getId());
return "Student deleted";
    }
    @PutMapping("/update{id}")
    public String updateStudent(@PathVariable Long id,@RequestBody StudentRequestDto studentRequestDto){
        studentService.update(id, studentRequestDto);
        return "Student updated";
    }
}
