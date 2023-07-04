package com.example.swithserver.domain.inspection.domain.survey;

import javax.persistence.Embeddable;

@Embeddable
public class Safety {
    private boolean didAdhereToSafetyRegulations;
    private boolean didFollowSafetyProcedures;
    private boolean wereColleaguesCompliantWithSafetyRegulations;
    private boolean wasSafetyManagementAndTrainingAdequate;
    private boolean wereThereAreasRequiringImprovementInSafety;
}
