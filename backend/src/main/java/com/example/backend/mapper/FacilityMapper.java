package com.example.backend.mapper;

import com.example.backend.dto.FacilityDto;
import com.example.backend.entity.Facility;
import org.springframework.stereotype.Component;

@Component
public class FacilityMapper {

    public FacilityDto facilityToDto(Facility facility) {
        FacilityDto facilityDto = new FacilityDto();
        facilityDto.setId(facility.getId());
        facilityDto.setName(facility.getName());
        facilityDto.setShortName(facility.getShortName());
        return facilityDto;
    }

    public Facility dtoToFacility(FacilityDto facilityDto) {
        Facility facility = new Facility();
        facility.setId(facilityDto.getId());
        facility.setName(facilityDto.getName());
        facility.setShortName(facilityDto.getShortName());
        return facility;
    }

}
