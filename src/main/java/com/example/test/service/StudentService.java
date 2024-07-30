package com.example.test.service;

import com.example.test.Entity.Lesson;
import com.example.test.Entity.Student;
import com.example.test.Entity.Teacher;
import com.example.test.dto.request.StudentRequestDto;
import com.example.test.dto.response.StudentResponseDto;
import com.example.test.repository.LessonRepository;
import com.example.test.repository.StudentRepository;
import com.example.test.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final LessonRepository lessonRepository;
    private final ModelMapper modelMapper;

    public List<StudentResponseDto> getAll() {
        List<Student> all = studentRepository.findAll();
        List<StudentResponseDto> list = all.stream()
                .map(item -> modelMapper.map(item, StudentResponseDto.class))
                .toList();
        return list;
    }

    public void create (StudentRequestDto dto) {
        Student student = modelMapper.map(dto, Student.class);

        List<Lesson> lessons = new ArrayList<>();
        List<Long> lessonIds = dto.getLessonIds();
        for (Long id : lessonIds) {
            Lesson byId = lessonRepository.findById(id).orElseThrow();
            lessons.add(byId);
        }

        List<Teacher> teachers = new ArrayList<>();
        List<Long> teacherIds = dto.getTeacherIds();
        for (Long id : teacherIds) {
            Teacher byId = teacherRepository.findById(id).orElseThrow();
            teachers.add(byId);
        }

        student.setLessonList(lessons);
        student.setTeacherList(teachers);
        studentRepository.save(student);
    }
    public StudentResponseDto findById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow();
        StudentResponseDto map = modelMapper.map(student, StudentResponseDto.class);
        return map;
    }


    public String delete(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        studentRepository.delete(student);
        return "Student deleted successfully";
    }

    public String update(Long id, StudentRequestDto studentRequestDto) {
        Student student = studentRepository.findById(id).orElseThrow();
        modelMapper.map(studentRequestDto, student);
        studentRepository.save(student);

        return "Student updated successfully";
    }

}
