package com.example.swithserver.domain.inspection.domain.survey;

import javax.persistence.Embeddable;

@Embeddable
public class RiskManagement {
    private boolean hasPotentialHazards;
    private boolean feltUnsafeWorkingEnvironment;
    private boolean receivedTrainingOnHazardAwarenessAndManagement;
    private boolean sufficientPreventiveMeasuresTaken;
}
