package com.example.swithserver.domain.inspection.domain.repository;

import com.example.swithserver.domain.inspection.domain.Inspection;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface InspectionRepository extends CrudRepository<Inspection, Long> {
    Optional<Inspection> findById(Long id);
}
