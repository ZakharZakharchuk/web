package com.example.backend.repository;

import com.example.backend.entity.Facility;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityRepository extends CrudRepository<Facility, Long> {
    List<Facility> findAll();
    Facility save(Facility facility);
    void deleteById(Long facilityId);
}
