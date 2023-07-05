package com.example.swithserver.domain.inspection.service;

import com.example.swithserver.domain.inspection.domain.Inspection;
import com.example.swithserver.domain.inspection.domain.repository.InspectionRepository;
import com.example.swithserver.domain.inspection.presentation.dto.request.CreateInspectionRequest;
import com.example.swithserver.domain.student.domain.Student;
import com.example.swithserver.domain.student.facade.StudentFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;

@RequiredArgsConstructor
@Service
public class CreateInspectionService {
    private final InspectionRepository inspectionRepository;
    private final StudentFacade studentFacade;

    @Transactional
    public void execute(CreateInspectionRequest request) {
        Student student = studentFacade.getCurrentUser();

        inspectionRepository.save(new Inspection(request, student));
    }
}
