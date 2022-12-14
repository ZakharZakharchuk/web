package com.example.backend.dto;

import java.util.Date;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ScheduleDto {

    private Long id;
    private Long teacherId;
    private Long disciplineId;
    private Long groupId;
    private Date time;
    @Pattern(regexp = "([A-Za-z0-9])+")
    private String classroom;
}
