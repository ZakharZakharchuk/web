package com.example.backend.dto;

import lombok.Data;

@Data
public class GroupDto {
    private Long id;
    private Long departmentId;
    private String name;
    private Integer course;
}
