package com.example.backend.service;

import com.example.backend.dto.StudentDto;
import com.example.backend.mapper.StudentMapper;
import com.example.backend.repository.StudentRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll().stream()
            .map(studentMapper::studentToDto).collect(
                Collectors.toList());
    }

    public StudentDto saveStudent(StudentDto studentDto) {
        return studentMapper.studentToDto(
            studentRepository.save(studentMapper.dtoToStudent(studentDto)));
    }

    public StudentDto updateStudent(StudentDto studentDto) {
        return studentMapper.studentToDto(
            studentRepository.save(studentMapper.dtoToStudent(studentDto)));
    }

    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
