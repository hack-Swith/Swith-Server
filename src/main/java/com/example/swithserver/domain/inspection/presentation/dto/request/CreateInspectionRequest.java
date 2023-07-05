package com.example.swithserver.domain.inspection.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateInspectionRequest {
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

    private Integer score;
}
