package com.example.backend.service;

import com.example.backend.dto.TeacherDto;
import java.util.List;

public interface TeacherService {

    List<TeacherDto> getAllTeachers();

    TeacherDto saveTeacher(TeacherDto teacherDto);

    TeacherDto updateTeacher(TeacherDto teacherDto);

    void deleteTeacherById(Long teacherId);
}
