package com.example.backend.dto;

import java.util.Date;
import lombok.Data;

@Data
public class ScheduleDto {

    private Long id;
    private Long teacherId;
    private Long disciplineId;
    private Long groupId;
    private Date time;
    private String classroom;
}
