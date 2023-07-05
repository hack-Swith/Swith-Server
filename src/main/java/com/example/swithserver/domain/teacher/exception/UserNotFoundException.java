package com.example.swithserver.domain.teacher.exception;

import com.example.swithserver.domain.teacher.exception.error.TeacherErrorCode;
import com.example.swithserver.global.error.CustomException;

public class UserNotFoundException extends CustomException {

	public final static UserNotFoundException EXCEPTION = new UserNotFoundException();

	public UserNotFoundException() {
		super(TeacherErrorCode.USER_NOT_FOUND);
	}
}
