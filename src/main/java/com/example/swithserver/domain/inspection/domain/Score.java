package com.example.swithserver.domain.inspection.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Score {
    VERY_DANGER("매우 위험"),
    DANGER("위험"),
    NORMAL("관심필요"),
    SAFE("안전");

    private final String score;
}
