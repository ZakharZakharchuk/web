package com.example.backend.controller;

import com.example.backend.dto.TeacherDto;
import com.example.backend.service.TeacherService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teachers")
@AllArgsConstructor
@CrossOrigin
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping("/getAll")
    public List<TeacherDto> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @PostMapping("/save")
    public TeacherDto saveTeacher(@RequestBody TeacherDto teacherDto) {
        return teacherService.saveTeacher(teacherDto);
    }

    @PostMapping("/update")
    public TeacherDto updateTeacher(@RequestBody TeacherDto teacherDto) {
        return teacherService.updateTeacher(teacherDto);
    }

    @PostMapping("/delete")
    public void deleteTeacher(@RequestBody Long teacherId) {
        teacherService.deleteTeacherById(teacherId);
    }
}
