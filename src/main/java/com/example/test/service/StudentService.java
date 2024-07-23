package com.example.test.service;

import com.example.test.Entity.Lesson;
import com.example.test.Entity.Student;
import com.example.test.Entity.TeacherEntity;
import com.example.test.dto.StudentRequestDto;
import com.example.test.dto.StudentResponseDto;
import com.example.test.repository.LessonRepository;
import com.example.test.repository.StudentRepository;
import com.example.test.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
       return  list;
}
public String create( StudentRequestDto studentRequestDto) {
    Student student = modelMapper.map(studentRequestDto, Student.class);

    List<Long> teacherIds = studentRequestDto.getTeacherIds();
    List<TeacherEntity> teachers = new ArrayList<>();
    for (Long id : teacherIds) {
        TeacherEntity teacher = teacherRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Teacher not found with id: " + id)
        );
        teachers.add(teacher);
    }
    student.setTeacherEntityList(teachers);
    List<Lesson> lessons = new ArrayList<>();
    List<Long>lessonIds=studentRequestDto.getLessonIds();
    for (Long id : lessonIds) {
        Lesson lesson = lessonRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Teacher not found with id: " + id)
        );
        lessons.add(lesson);
    }
    student.setLessonList(lessons);
    studentRepository.save(student);
    return "success";
}


public StudentResponseDto findById(Long id) {
    Student student = studentRepository.findById(id).orElseThrow();
    StudentResponseDto map=modelMapper.map(student, StudentResponseDto.class);
    return map;
}




public String delete( Long studentId) {
    Student student = studentRepository.findById(studentId).orElseThrow();
    studentRepository.delete(student);
    return "Student deleted successfully" ;
}
    public String update(Long id,  StudentRequestDto studentRequestDto) {
    Student student = studentRepository.findById(id).orElseThrow();
    modelMapper.map(studentRequestDto, student);
    studentRepository.save(student);

    return "Student updated successfully" ;
}

}
