package com.example.swithserver.domain.teacher.exception.error;

import com.example.swithserver.global.error.ErrorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TeacherErrorCode implements ErrorCode {

	PASSWORD_MISMATCH(409, "교사의 비밀번호가 일치하지 않습니다."),
	USER_NOT_FOUND(404, "일치하는 교사을 찾을 수 없습니다.");

	private final int status;
	private final String message;

}
