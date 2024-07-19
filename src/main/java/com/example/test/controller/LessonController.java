package com.example.test.controller;

import com.example.test.dto.LessonDto;
import com.example.test.dto.StudentRequestDto;
import com.example.test.service.LessonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lesson")
public class LessonController {
    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }
    @GetMapping("/getAll")
    public List<LessonDto>getlesson(){
        return lessonService.getAll();
    }
    @PostMapping("/create")
    public String createLesson(@RequestBody LessonDto lessonDto){
        lessonService.create(lessonDto);
        return "Lesson created";
    }
}
