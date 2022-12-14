package com.example.backend.repository;

import com.example.backend.entity.Facility;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityRepository extends CrudRepository<Facility, Long> {
    List<Facility> findAll();

    Optional<Facility> findById(Long facilityId);

    Facility save(Facility facility);
    void deleteById(Long facilityId);
}
