package com.example.swithserver.domain.inspection.exception.error;

import com.example.swithserver.global.error.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum InspectionErrorCode implements ErrorCode {

	INSPECTION_NOT_FOUND(404, "일치하는 검사를 찾을 수 없습니다");

	private final int status;
	private final String message;

}
