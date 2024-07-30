package com.example.test.controller;

import com.example.test.dto.request.LessonRequestDto;
import com.example.test.dto.response.LessonResponseDto;
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
    public List<LessonResponseDto>getlesson(){
        return lessonService.getAll();
    }
    @PostMapping("/create")
    public LessonResponseDto createLesson(@RequestBody LessonRequestDto lessonRequestDto){
       return lessonService.create(lessonRequestDto);

    }
}
