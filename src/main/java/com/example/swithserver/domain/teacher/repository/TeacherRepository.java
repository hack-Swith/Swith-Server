package com.example.swithserver.domain.teacher.repository;

import com.example.swithserver.domain.teacher.domain.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, String> {
}
