package com.example.swithserver.domain.student.exception;

import com.example.swithserver.domain.student.exception.error.StudentErrorCode;
import com.example.swithserver.global.error.CustomException;

public class UserNotFoundException extends CustomException {

	public final static UserNotFoundException EXCEPTION = new UserNotFoundException();

	public UserNotFoundException() {
		super(StudentErrorCode.USER_NOT_FOUND);
	}
}
