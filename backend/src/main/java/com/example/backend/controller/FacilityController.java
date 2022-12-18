package com.example.backend.controller;

import com.example.backend.dto.FacilityDto;
import com.example.backend.service.FacilityService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/facilities")
@AllArgsConstructor
@CrossOrigin
public class FacilityController {
    private final FacilityService facilityService;

    @GetMapping("/getAll")
    public List<FacilityDto> getAllFacilities() {
        return facilityService.getAllFacilities();
    }

    @PostMapping("/save")
    public FacilityDto saveFacility(@RequestBody FacilityDto facilityDto) {
        return facilityService.saveFacility(facilityDto);
    }

    @PostMapping("/update")
    public FacilityDto updateFacility(@RequestBody FacilityDto facilityDto) {
        return facilityService.updateFacility(facilityDto);
    }

    @PostMapping("/delete")
    public void deleteFacility(@RequestBody Long facilityId) {
        facilityService.deleteFacilityById(facilityId);
    }
}
