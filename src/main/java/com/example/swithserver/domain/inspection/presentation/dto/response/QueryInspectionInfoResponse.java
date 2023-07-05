package com.example.swithserver.domain.inspection.presentation.dto.response;

import com.example.swithserver.domain.inspection.domain.Score;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class QueryInspectionInfoResponse {
    private boolean didAdhereToSafetyRegulations;

    private boolean didFollowSafetyProcedures;

    private boolean wereColleaguesCompliantWithSafetyRegulations;

    private boolean wasSafetyManagementAndTrainingAdequate;

    private boolean wereThereAreasRequiringImprovementInSafety;

    private boolean hasPotentialHazards;

    private boolean feltUnsafeWorkingEnvironment;

    private boolean receivedTrainingOnHazardAwarenessAndManagement;

    private boolean sufficientPreventiveMeasuresTaken;

    private boolean isPositiveWorkEnvironment;

    private boolean hasExperiencedBullying;

    private boolean isUncomfortableAtWorkDueToWitnessingBullying;

    private boolean hasExperiencedSexualHarassment;

    private boolean hasExperiencedInappropriateCommentsOrActions;
    private Score score;
    private LocalDate date;
    private String company;
}
