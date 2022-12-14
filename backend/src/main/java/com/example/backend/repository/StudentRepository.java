package com.example.backend.repository;

import com.example.backend.entity.Student;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findAll();
    Student save(Student student);
    void deleteById(Student studentId);
}
