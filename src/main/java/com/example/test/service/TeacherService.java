package com.example.test.service;
import com.example.test.Entity.Teacher;
import com.example.test.dto.TeacherDto;
import com.example.test.repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final ModelMapper modelMapper;
    public TeacherService(TeacherRepository teacherRepository, ModelMapper modelMapper) {
        this.teacherRepository = teacherRepository;
        this.modelMapper = modelMapper;
    }
    List<TeacherDto> teacherDtos = new ArrayList<>();


    public List<TeacherDto> getAll() {
        List<Teacher> all = teacherRepository.findAll();
        List<TeacherDto> list = all.stream()
                .map(item -> modelMapper.map(item, TeacherDto.class))
                .toList();
        return  list;
    }
    public TeacherDto create( TeacherDto teacherDto) {
        Teacher map=modelMapper.map(teacherDto, Teacher.class);

      return  modelMapper.map(teacherRepository.save(map),TeacherDto.class);

    }
}
