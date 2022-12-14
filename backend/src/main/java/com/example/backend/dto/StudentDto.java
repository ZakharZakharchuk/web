package com.example.backend.dto;

import lombok.Data;

@Data
public class StudentDto {

    private Long id;
    private Long groupId;
    private String name;
    private String email;
    private String phone;
}
