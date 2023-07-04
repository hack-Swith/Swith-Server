package com.example.swithserver.global.jwt.exception.error;

import com.example.swithserver.global.error.ErrorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TokenErrorCode implements ErrorCode {

	TOKEN_UNAUTHORIZED(401,"토큰이 유효 하지 않습니다."),
	TOKEN_BAD_REQUEST(401,"토큰이 올바르지 않습니다."),
	NOT_STUDENT_TOKEN(403, "학생 권한이 존재하지 않습니다."),
	NOT_TEACHER_TOKEN(403, "교사 권한이 존재하지 않습니다.");

	private final int status;
	private final String message;

}
