package com.example.test.controller;

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
   return studentService.create(studentRequestDto);
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
