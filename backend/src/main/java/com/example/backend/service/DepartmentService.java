package com.example.backend.service;

import com.example.backend.dto.DepartmentDto;
import com.example.backend.entity.Department;
import com.example.backend.mapper.DepartmentMapper;
import com.example.backend.repository.DepartmentRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public List<DepartmentDto> getAllDepartments() {
        return departmentRepository.findAll().stream()
            .map(departmentMapper::departmentToDto).collect(
                Collectors.toList());
    }

    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        return departmentMapper.departmentToDto(
            departmentRepository.save(departmentMapper.dtoToDepartment(departmentDto)));
    }

    public DepartmentDto updateDepartment(DepartmentDto departmentDto) {
        return departmentMapper.departmentToDto(
            departmentRepository.save(departmentMapper.dtoToDepartment(departmentDto)));
    }

    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}