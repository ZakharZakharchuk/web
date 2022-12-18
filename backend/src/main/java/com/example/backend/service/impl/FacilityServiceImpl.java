package com.example.backend.service.impl;

import com.example.backend.dto.FacilityDto;
import com.example.backend.mapper.FacilityMapper;
import com.example.backend.repository.FacilityRepository;
import com.example.backend.service.FacilityService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FacilityServiceImpl implements FacilityService {

    private final FacilityRepository facilityRepository;
    private final FacilityMapper facilityMapper;

    public List<FacilityDto> getAllFacilities() {
        return facilityRepository.findAll().stream()
            .map(facilityMapper::facilityToDto).collect(
                Collectors.toList());
    }

    public FacilityDto saveFacility(FacilityDto facilityDto) {
        return facilityMapper.facilityToDto(
            facilityRepository.save(facilityMapper.dtoToFacility(facilityDto)));
    }

    public FacilityDto updateFacility(FacilityDto facilityDto) {
        return facilityMapper.facilityToDto(
            facilityRepository.save(facilityMapper.dtoToFacility(facilityDto)));
    }

    public void deleteFacilityById(Long facilityId) {
        facilityRepository.deleteById(facilityId);
    }
}

