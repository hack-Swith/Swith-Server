package com.example.swithserver.domain.inspection.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryInspectionListResponse {
    private String name;
    private int classroom;
    private int number;
    private List<QueryInspectionInfoResponse> responseList;
}
