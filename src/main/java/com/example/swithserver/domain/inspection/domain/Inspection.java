package com.example.swithserver.domain.inspection.domain;

import com.example.swithserver.domain.inspection.presentation.dto.request.CreateInspectionRequest;
import com.example.swithserver.domain.student.domain.Student;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Score score;

    private String date;


    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    private Long schoolId;

    public Inspection(CreateInspectionRequest request, Student student) {
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
        this.hasExperiencedSexualHarassment = request.isHasExperiencedSexualHarassment();
        this.date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy년 M월 d일"));;
        this.student = student;
        this.schoolId = student.getSchoolId();
        this.score = checkScore(request);
    }

    private Score checkScore(CreateInspectionRequest request) {
        int count = 0;
        if (request.isDidAdhereToSafetyRegulations())
            count++;

        if (request.isDidFollowSafetyProcedures())
            count++;

        if (request.isWereColleaguesCompliantWithSafetyRegulations())
            count++;

        if (request.isWasSafetyManagementAndTrainingAdequate())
            count++;

        if (request.isWereThereAreasRequiringImprovementInSafety())
            count++;

        if (request.isHasPotentialHazards())
            count++;

        if (request.isFeltUnsafeWorkingEnvironment())
            count++;

        if (request.isReceivedTrainingOnHazardAwarenessAndManagement())
            count++;

        if (request.isSufficientPreventiveMeasuresTaken())
            count++;

        if (request.isPositiveWorkEnvironment())
            count++;

        if (request.isHasExperiencedBullying())
            count++;

        if (request.isUncomfortableAtWorkDueToWitnessingBullying())
            count++;

        if (request.isHasExperiencedSexualHarassment())
            count++;

        if (request.isHasExperiencedInappropriateCommentsOrActions())
            count++;

        if(count >= 10 && count <= 14) {
            return Score.VERY_DANGER;
        }
        else if (count >= 6 && count <= 9) {
            return Score.DANGER;
        }
        else if (count >= 3 && count <= 5) {
            return Score.NORMAL;
        }
        return Score.SAFE;
    }
}
