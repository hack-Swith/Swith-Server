package com.example.swithserver.domain.inspection.domain.survey;

import javax.persistence.Embeddable;

@Embeddable
public class Survey {
    private Culture culture;
    private RiskManagement RiskManagement;
    private Safety safety;
}
