package com.example.swithserver.domain.user.exception;

import com.example.swithserver.global.error.CustomException;
import com.example.swithserver.global.error.ErrorCode;

public class UserExistException extends CustomException {
    public static final CustomException EXCEPTION =
            new UserExistException();

    private UserExistException() {
        super(ErrorCode.USER_EXIST);
    }
}