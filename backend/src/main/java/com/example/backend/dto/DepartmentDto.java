package com.example.backend.dto;

import lombok.Data;

@Data
public class DepartmentDto {
    private Long id;
    private Long facilityId;
    private String name;
    private String shortName;
}
