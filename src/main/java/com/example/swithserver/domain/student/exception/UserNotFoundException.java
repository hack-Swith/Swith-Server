package com.example.swithserver.domain.student.exception;


import com.example.swithserver.global.error.CustomException;
import com.example.swithserver.global.error.ErrorCode;

public class UserNotFoundException extends CustomException {
    public static final CustomException EXCEPTION =
            new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}