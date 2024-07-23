package com.example.test.service;

import com.example.test.Entity.Lesson;
import com.example.test.dto.LessonDto;
import com.example.test.dto.TeacherDto;
import com.example.test.repository.LessonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;
    private final ModelMapper modelMapper;

    public LessonService(LessonRepository lessonRepository, ModelMapper modelMapper) {
        this.lessonRepository = lessonRepository;
        this.modelMapper = modelMapper;
    }
    List<LessonDto> lessonDtos = new ArrayList<>();


    public List<LessonDto> getAll() {
        List<Lesson> all = lessonRepository.findAll();
        return all.stream()
                .map(item -> modelMapper.map(item,LessonDto.class))
                .toList();
    }
    public LessonDto create( LessonDto lessonDto) {
        Lesson map=modelMapper.map(lessonDto, Lesson.class);
        return  modelMapper.map(lessonRepository.save(map), LessonDto.class);
    }
}
