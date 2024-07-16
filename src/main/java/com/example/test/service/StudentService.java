package com.example.test.service;

import com.example.test.Entity.StudentEntity;
import com.example.test.dto.StudentRequestDto;
import com.example.test.dto.StudentResponseDto;
import com.example.test.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    public StudentService(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }
List<StudentResponseDto> studentResponseDtos = new ArrayList<>();


    public List<StudentResponseDto> getAll() {
        List<StudentEntity> all = studentRepository.findAll();
        List<StudentResponseDto> list = all.stream()
                .map(item -> modelMapper.map(item, StudentResponseDto.class))
                .toList();
       return  list;
}
public String create(@RequestBody StudentRequestDto studentRequestDto) {
    StudentEntity map=modelMapper.map(studentRequestDto,StudentEntity.class);

    studentRepository.save(map);
    return "Student created successfully";
}
public String delete(@RequestParam Long studentId) {
    StudentEntity studentEntity = studentRepository.findById(studentId).orElseThrow();
    studentRepository.delete(studentEntity);
    return "Student deleted successfully" ;
}
@PutMapping("/update{id}")
    public String update(@PathVariable Long id, @RequestBody StudentRequestDto studentRequestDto) {
    StudentEntity studentEntity = studentRepository.findById(id).orElseThrow();
    modelMapper.map(studentRequestDto, studentEntity);
    studentRepository.save(studentEntity);

    return "Student updated successfully" ;
}
}
