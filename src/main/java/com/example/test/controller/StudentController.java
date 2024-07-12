package com.example.test.controller;

import com.example.test.dto.StudentDto;
import com.example.test.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Student")
@RequiredArgsConstructor
public class StudentController {

 private final StudentService studentService;
 public StudentController(StudentService studentService) {
     this.studentService = studentService;
 }

    @GetMapping("/getStudent")
    public List<StudentDto> getStudent(){
        return studentService.getAll();

    }
    @PostMapping("/create")
    public String createStudent(@RequestBody StudentDto studentDto){
    studentService.create(studentDto);
    return "Student created";
    }
    @DeleteMapping("/delete")
    public String deleteStudent(@RequestBody StudentDto studentDto){
studentService.delete(studentDto.getId());
return "Student deleted";
    }
    @PutMapping("/update{id}")
    public String updateStudent(@PathVariable Long id,@RequestBody StudentDto studentDto){
        studentService.update(id, studentDto);
        return "Student updated";
    }
}
