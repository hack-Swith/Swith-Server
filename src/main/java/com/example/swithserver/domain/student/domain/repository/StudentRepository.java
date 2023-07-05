package com.example.swithserver.domain.student.domain.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

import com.example.swithserver.domain.student.domain.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
    Optional<Student> findById(String id);
    List<Student> findAllByIsInspectionOrderByClassroomDesc(Boolean isInspection);
}