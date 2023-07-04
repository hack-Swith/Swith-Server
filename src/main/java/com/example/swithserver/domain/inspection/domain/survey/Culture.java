package com.example.swithserver.domain.inspection.domain.survey;

import javax.persistence.Embeddable;

@Embeddable
public class Culture {
    private boolean isPositiveWorkEnvironment;
    private boolean hasExperiencedBullying;
    private boolean isUncomfortableAtWorkDueToWitnessingBullying;
    private boolean hasExperiencedSexualHarassment;
    private boolean hasExperiencedInappropriateCommentsOrActions;
}
