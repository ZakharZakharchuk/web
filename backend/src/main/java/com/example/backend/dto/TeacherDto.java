package com.example.backend.dto;

import lombok.Data;

@Data
public class TeacherDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
}
