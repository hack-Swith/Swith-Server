package com.example.swithserver.domain.inspection.domain.repository;

import com.example.swithserver.domain.inspection.domain.Inspection;
import com.example.swithserver.domain.inspection.domain.Score;
import com.example.swithserver.domain.student.domain.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface InspectionRepository extends CrudRepository<Inspection, Long> {
    Optional<Inspection> findById(Long id);
    List<Inspection> findAllBySchoolIdAndScoreOrderByIdDesc(Long schoolId, Score score);

}
