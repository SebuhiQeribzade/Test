package com.example.test.service;

import com.example.test.Entity.LessonEntity;
import com.example.test.Entity.TeacherEntity;
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
        List<LessonEntity> all = lessonRepository.findAll();
        List<LessonDto> list = all.stream()
                .map(item -> modelMapper.map(item,LessonDto.class))
                .toList();
        return  list;
    }
    public String create( LessonDto lessonDto) {
        LessonEntity map=modelMapper.map(lessonDtos,LessonEntity.class);

        lessonRepository.save(map);
        return "Lesson created successfully";
    }
}
