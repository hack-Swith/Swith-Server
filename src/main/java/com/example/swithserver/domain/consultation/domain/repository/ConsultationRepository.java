package com.example.swithserver.domain.consultation.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.swithserver.domain.consultation.domain.Consultation;
import com.example.swithserver.domain.student.domain.Student;

public interface ConsultationRepository extends CrudRepository<Consultation, Long> {
	List<Consultation> findAllByStudentOrderByIdDesc(Student student);
	List<Consultation> findAllBySchoolIdOrderByIsStatus(Long schoolId);
}
