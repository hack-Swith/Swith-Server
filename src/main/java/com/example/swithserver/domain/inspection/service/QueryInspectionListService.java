package com.example.swithserver.domain.inspection.service;

import com.example.swithserver.domain.inspection.domain.repository.InspectionRepository;
import com.example.swithserver.domain.inspection.presentation.dto.response.QueryInspectionListResponse;
import com.example.swithserver.domain.inspection.presentation.dto.response.QueryInspectionResponse;
import com.example.swithserver.domain.student.domain.Student;
import com.example.swithserver.domain.student.domain.repository.StudentRepository;
import com.example.swithserver.domain.student.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QueryInspectionListService {
    private final InspectionRepository inspectionRepository;
    private final StudentRepository studentRepository;

    public QueryInspectionListResponse execute(String id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
        List<QueryInspectionResponse> inspectionList = inspectionRepository.findAllByStudent(student)
                .stream()
                .map(it -> new QueryInspectionResponse(it.getScore(), it.getDate(), it.getCompany())).toList();

        return new QueryInspectionListResponse(student.getName(), student.getClassroom(), student.getNumber(), inspectionList);
    }
}
