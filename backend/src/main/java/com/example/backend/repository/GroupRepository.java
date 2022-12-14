package com.example.backend.repository;

import com.example.backend.entity.Group;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {
    List<Group> findAll();
    Group save(Group group);
    void deleteById(Long groupId);
}
