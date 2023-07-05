package com.example.swithserver.domain.inspection.presentation.dto.response;

import com.example.swithserver.domain.inspection.domain.Score;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class QueryInspectionResponse {
    private Score score;
    private LocalDate date;
    private String company;
}
