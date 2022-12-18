package com.example.backend.controller;

import com.example.backend.dto.ScheduleDto;
import com.example.backend.service.impl.ScheduleServiceImpl;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedules")
@AllArgsConstructor
public class ScheduleController {
    private final ScheduleServiceImpl scheduleService;

    @GetMapping("/getAll")
    public List<ScheduleDto> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @PostMapping("/save")
    public ScheduleDto saveSchedule(@RequestBody ScheduleDto scheduleDto) {
        return scheduleService.saveSchedule(scheduleDto);
    }

    @PostMapping("/update")
    public ScheduleDto updateSchedule(@RequestBody ScheduleDto scheduleDto) {
        return scheduleService.updateSchedule(scheduleDto);
    }

    @PostMapping("/delete")
    public void deleteSchedule(@RequestBody Long scheduleId) {
        scheduleService.deleteScheduleById(scheduleId);
    }
}
