package com.example.backend.mapper;

import com.example.backend.dto.TeacherDto;
import com.example.backend.entity.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {

    public TeacherDto teacherToDto(Teacher teacher){
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setId(teacher.getId());
        teacherDto.setName(teacher.getName());
        teacherDto.setEmail(teacher.getEmail());
        teacherDto.setSurname(teacher.getSurname());
        teacherDto.setPhone(teacher.getPhone());
        return teacherDto;
    }
    public Teacher dtoToTeacher(TeacherDto teacherDto){
        Teacher teacher = new Teacher();
        teacher.setId(teacher.getId());
        teacher.setName(teacher.getName());
        teacher.setEmail(teacher.getEmail());
        teacher.setSurname(teacher.getSurname());
        teacher.setPhone(teacher.getPhone());
        return teacher;
    }
}
