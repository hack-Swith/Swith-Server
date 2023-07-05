package com.example.swithserver.domain.inspection.service;

import com.example.swithserver.domain.inspection.domain.Inspection;
import com.example.swithserver.domain.inspection.domain.repository.InspectionRepository;
import com.example.swithserver.domain.inspection.presentation.dto.request.CreateInspectionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;

@RequiredArgsConstructor
@Service
public class CreateInspectionService {
    private final InspectionRepository inspectionRepository;

    @Transactional
    public void execute(CreateInspectionRequest request) {
        inspectionRepository.save(new Inspection(request));
    }
}
