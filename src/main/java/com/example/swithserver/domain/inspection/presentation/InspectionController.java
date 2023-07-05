package com.example.swithserver.domain.inspection.presentation;

import com.example.swithserver.domain.inspection.presentation.dto.request.CreateInspectionRequest;
import com.example.swithserver.domain.inspection.presentation.dto.response.QueryInspectionInfoResponse;
import com.example.swithserver.domain.inspection.presentation.dto.response.QueryInspectionListResponse;
import com.example.swithserver.domain.inspection.service.CreateInspectionService;
import com.example.swithserver.domain.inspection.service.QueryInspectionInfoService;
import com.example.swithserver.domain.inspection.service.QueryInspectionListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/inspection")
public class InspectionController {
    private final CreateInspectionService createInspectionService;
    private final QueryInspectionInfoService queryInspectionInfoService;
    private final QueryInspectionListService queryInspectionListService;

    @PostMapping
    public void createInspection(CreateInspectionRequest request) {
        createInspectionService.execute(request);
    }

    @GetMapping("/info/{inspection-id}")
    public QueryInspectionInfoResponse queryInspectionInfo(@PathVariable("inspection-id") Long inspectionId) {
        return queryInspectionInfoService.execute(inspectionId);
    }

    @GetMapping("/{student-id}")
    public QueryInspectionListResponse queryInspectionList(@PathVariable("student-id") String studentId) {
        return queryInspectionListService.execute(studentId);
    }
}
