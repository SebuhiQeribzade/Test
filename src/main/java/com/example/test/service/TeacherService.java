package com.example.test.service;
import com.example.test.Entity.Teacher;
import com.example.test.dto.request.TeacherRequestDto;
import com.example.test.dto.response.TeacherResponseDto;
import com.example.test.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@AllArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final ModelMapper modelMapper;


    public List<TeacherResponseDto> getAll() {
        List<Teacher> all = teacherRepository.findAll();
        return all.stream()
                .map(item -> modelMapper.map(item, TeacherResponseDto.class))
                .toList();
    }
    public TeacherResponseDto create(TeacherRequestDto teacherRequestDto) {
        Teacher map=modelMapper.map(teacherRequestDto, Teacher.class);
      return  modelMapper.map(teacherRepository.save(map), TeacherResponseDto.class);
    }
}
