package com.example.backend.service;

import com.example.backend.dto.FacilityDto;
import java.util.List;

public interface FacilityService {

    List<FacilityDto> getAllFacilities();

    FacilityDto saveFacility(FacilityDto facilityDto);

    FacilityDto updateFacility(FacilityDto facilityDto);

    void deleteFacilityById(Long facilityId);
}
