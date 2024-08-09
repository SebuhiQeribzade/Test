package com.example.test.controller;

import com.example.test.dto.request.StudentRequestDto;
import com.example.test.dto.response.StudentResponseDto;
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
    public void createStudent(@RequestBody StudentRequestDto studentRequestDto){
    studentService.create(studentRequestDto);
    }

    @GetMapping("/findById")
    public StudentResponseDto findStudent(@PathVariable Long id){
     StudentResponseDto byId=studentService.findById(id);
     return byId;
    }


    @DeleteMapping("/delete")
    public String deleteStudent(@RequestBody StudentResponseDto studentResponseDto){
    return studentService.delete(studentResponseDto.getId());

    }
    @PutMapping("/update{id}")
    public String updateStudent(@PathVariable Long id,@RequestBody StudentRequestDto studentRequestDto){
    return     studentService.update(id, studentRequestDto);

    }
}
