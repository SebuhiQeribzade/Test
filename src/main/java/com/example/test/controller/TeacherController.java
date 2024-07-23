package com.example.test.controller;

import com.example.test.dto.LessonDto;
import com.example.test.dto.TeacherDto;
import com.example.test.service.LessonService;
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
    public List<TeacherDto> getteacher(){
        return teacherService.getAll();
    }
    @PostMapping("/create")
    public TeacherDto createLesson(@RequestBody TeacherDto teacherDto){
      return   teacherService.create(teacherDto);

    }
}
