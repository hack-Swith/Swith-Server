package com.example.swithserver.global.jwt.exception;

import com.example.swithserver.global.error.CustomException;
import com.example.swithserver.global.jwt.exception.error.TokenErrorCode;

public class NotStudentTokenException extends CustomException {

	public final static NotStudentTokenException EXCEPTION = new NotStudentTokenException();

	public NotStudentTokenException() {
		super(TokenErrorCode.NOT_STUDENT_TOKEN);
	}

}
