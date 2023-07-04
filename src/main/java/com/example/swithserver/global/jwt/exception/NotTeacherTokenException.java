package com.example.swithserver.global.jwt.exception;

import com.example.swithserver.global.error.CustomException;
import com.example.swithserver.global.jwt.exception.error.TokenErrorCode;

public class NotTeacherTokenException extends CustomException {

	public final static NotTeacherTokenException EXCEPTION = new NotTeacherTokenException();

	public NotTeacherTokenException() {
		super(TokenErrorCode.NOT_TEACHER_TOKEN);
	}

}
