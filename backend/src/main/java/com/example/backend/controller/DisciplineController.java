package com.example.backend.controller;

import com.example.backend.dto.DisciplineDto;
import com.example.backend.service.DisciplineService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/disciplines")
@AllArgsConstructor
@CrossOrigin
public class DisciplineController {
    private final DisciplineService departmentService;

    @GetMapping("/getAll")
    public List<DisciplineDto> getAllDisciplines() {
        return departmentService.getAllDisciplines();
    }

    @PostMapping("/save")
    public DisciplineDto saveDiscipline(@Validated @RequestBody DisciplineDto disciplineDto) {
        return departmentService.saveDiscipline(disciplineDto);
    }

    @PostMapping("/update")
    public DisciplineDto updateDiscipline(@Validated @RequestBody DisciplineDto disciplineDto) {
        return departmentService.updateDiscipline(disciplineDto);
    }

    @PostMapping("/delete")
    public void deleteDiscipline(@RequestBody Long departmentId) {
        departmentService.deleteDisciplineById(departmentId);
    }
}
