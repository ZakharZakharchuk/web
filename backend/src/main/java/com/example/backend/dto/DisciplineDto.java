package com.example.backend.dto;

import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class DisciplineDto {

    private Long id;
    @Pattern(regexp = "([A-Za-z0-9])+")
    private String name;
}
