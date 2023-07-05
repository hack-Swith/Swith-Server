package com.example.swithserver.domain.inspection.domain;

import com.example.swithserver.domain.inspection.presentation.dto.request.CreateInspectionRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Inspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private boolean didAdhereToSafetyRegulations;

    @Column(nullable = false)
    private boolean didFollowSafetyProcedures;

    @Column(nullable = false)
    private boolean wereColleaguesCompliantWithSafetyRegulations;

    @Column(nullable = false)
    private boolean wasSafetyManagementAndTrainingAdequate;

    @Column(nullable = false)
    private boolean wereThereAreasRequiringImprovementInSafety;

    @Column(nullable = false)
    private boolean hasPotentialHazards;

    @Column(nullable = false)
    private boolean feltUnsafeWorkingEnvironment;

    @Column(nullable = false)
    private boolean receivedTrainingOnHazardAwarenessAndManagement;

    @Column(nullable = false)
    private boolean sufficientPreventiveMeasuresTaken;

    @Column(nullable = false)
    private boolean isPositiveWorkEnvironment;

    @Column(nullable = false)
    private boolean hasExperiencedBullying;

    @Column(nullable = false)
    private boolean isUncomfortableAtWorkDueToWitnessingBullying;

    @Column(nullable = false)
    private boolean hasExperiencedSexualHarassment;

    @Column(nullable = false)
    private boolean hasExperiencedInappropriateCommentsOrActions;

    private Integer score;

    public Inspection(CreateInspectionRequest request) {
        this.didAdhereToSafetyRegulations = request.isDidAdhereToSafetyRegulations();
        this.didFollowSafetyProcedures = request.isDidFollowSafetyProcedures();
        this.wereColleaguesCompliantWithSafetyRegulations = request.isWereColleaguesCompliantWithSafetyRegulations();
        this.wasSafetyManagementAndTrainingAdequate = request.isWasSafetyManagementAndTrainingAdequate();
        this.wereThereAreasRequiringImprovementInSafety = request.isWereThereAreasRequiringImprovementInSafety();
        this.hasPotentialHazards = request.isHasPotentialHazards();
        this.feltUnsafeWorkingEnvironment = request.isFeltUnsafeWorkingEnvironment();
        this.receivedTrainingOnHazardAwarenessAndManagement = request.isReceivedTrainingOnHazardAwarenessAndManagement();
        this.sufficientPreventiveMeasuresTaken = request.isSufficientPreventiveMeasuresTaken();
        this.isPositiveWorkEnvironment = request.isPositiveWorkEnvironment();
        this.hasExperiencedBullying = request.isHasExperiencedBullying();
        this.isUncomfortableAtWorkDueToWitnessingBullying = request.isUncomfortableAtWorkDueToWitnessingBullying();
        this.hasExperiencedInappropriateCommentsOrActions = request.isHasExperiencedInappropriateCommentsOrActions();
        this.score = request.getScore();
    }
}
