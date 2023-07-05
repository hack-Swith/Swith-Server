package com.example.swithserver.domain.inspection.service;

import com.example.swithserver.domain.inspection.domain.Inspection;
import com.example.swithserver.domain.inspection.domain.repository.InspectionRepository;
import com.example.swithserver.domain.inspection.exception.InspectionNotFoundException;
import com.example.swithserver.domain.inspection.presentation.dto.response.QueryInspectionInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QueryInspectionInfoService {
    private final InspectionRepository inspectionRepository;

    public QueryInspectionInfoResponse execute(Long id) {
        Inspection inspection = inspectionRepository.findById(id)
                .orElseThrow(() -> InspectionNotFoundException.EXCEPTION);
        return QueryInspectionInfoResponse.builder()
                .company(inspection.getCompany())
                .date(inspection.getDate())
                .didAdhereToSafetyRegulations(inspection.isDidAdhereToSafetyRegulations())
                .didFollowSafetyProcedures(inspection.isDidFollowSafetyProcedures())
                .feltUnsafeWorkingEnvironment(inspection.isFeltUnsafeWorkingEnvironment())
                .hasExperiencedBullying(inspection.isHasExperiencedBullying())
                .score(inspection.getScore())
                .hasExperiencedInappropriateCommentsOrActions(inspection.isHasExperiencedInappropriateCommentsOrActions())
                .hasExperiencedSexualHarassment(inspection.isHasExperiencedSexualHarassment())
                .hasPotentialHazards(inspection.isHasPotentialHazards())
                .isPositiveWorkEnvironment(inspection.isPositiveWorkEnvironment())
                .isUncomfortableAtWorkDueToWitnessingBullying(inspection.isUncomfortableAtWorkDueToWitnessingBullying())
                .receivedTrainingOnHazardAwarenessAndManagement(inspection.isReceivedTrainingOnHazardAwarenessAndManagement())
                .wasSafetyManagementAndTrainingAdequate(inspection.isWasSafetyManagementAndTrainingAdequate())
                .sufficientPreventiveMeasuresTaken(inspection.isSufficientPreventiveMeasuresTaken())
                .wereColleaguesCompliantWithSafetyRegulations(inspection.isWereColleaguesCompliantWithSafetyRegulations())
                .wereThereAreasRequiringImprovementInSafety(inspection.isWereThereAreasRequiringImprovementInSafety())
                .build();
    }
}
