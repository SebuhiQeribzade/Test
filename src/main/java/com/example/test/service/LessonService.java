package com.example.test.service;

import com.example.test.Entity.Lesson;
import com.example.test.dto.request.LessonRequestDto;
import com.example.test.dto.response.LessonResponseDto;
import com.example.test.repository.LessonRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LessonService {
    private final LessonRepository lessonRepository;
    private final ModelMapper modelMapper;


    public List<LessonResponseDto> getAll() {
        List<Lesson> all = lessonRepository.findAll();
        return all.stream()
                .map(item -> modelMapper.map(item, LessonResponseDto.class))
                .toList();
    }
    public LessonResponseDto create(LessonRequestDto lessonRequestDto) {
        Lesson map=modelMapper.map(lessonRequestDto, Lesson.class);
        return  modelMapper.map(lessonRepository.save(map), LessonResponseDto.class);
    }


    public String checkName (String name,String surname){
        return name+surname;
    }

}
