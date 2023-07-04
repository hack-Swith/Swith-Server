package com.example.swithserver.domain.consultation.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.swithserver.domain.consultation.domain.Consultation;

public interface ConsultationRepository extends CrudRepository<Consultation, Long> {
}
