package com.example.backend.mapper;

import com.example.backend.dto.StudentDto;
import com.example.backend.entity.Student;
import com.example.backend.repository.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StudentMapper {

    private final GroupRepository groupRepository;

    public StudentDto studentToDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setEmail(student.getEmail());
        studentDto.setPhone(student.getPhone());
        studentDto.setGroupId(student.getGroup().getId());
        return studentDto;
    }

    public Student dtoToStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setId(student.getId());
        student.setName(student.getName());
        student.setEmail(student.getEmail());
        student.setPhone(student.getPhone());
        student.setGroup(groupRepository.findById(studentDto.getGroupId()).get());
        return student;
    }
}
