package com.example.test.controller;

import com.example.test.dto.request.TeacherRequestDto;
import com.example.test.dto.response.TeacherResponseDto;
import com.example.test.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @GetMapping("/getAll")
    public List<TeacherResponseDto> getteacher(){
        return teacherService.getAll();
    }
    @PostMapping("/create")
    public TeacherResponseDto createLesson(@RequestBody TeacherRequestDto teacherRequestDto){
      return   teacherService.create(teacherRequestDto);

    }
}
