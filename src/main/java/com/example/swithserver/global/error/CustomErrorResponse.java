package com.example.swithserver.global.error;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomErrorResponse {

    private final int status;
    private final String message;

}