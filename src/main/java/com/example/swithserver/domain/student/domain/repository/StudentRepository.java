package com.example.swithserver.domain.student.domain.repository;

import com.example.swithserver.domain.student.domain.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Long> {
    Optional<Student> findById(String id);
}