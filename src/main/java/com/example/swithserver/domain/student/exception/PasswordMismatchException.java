package com.example.swithserver.domain.student.exception;


import com.example.swithserver.global.error.CustomException;
import com.example.swithserver.global.error.ErrorCode;

public class PasswordMismatchException extends CustomException {
    public static final CustomException EXCEPTION =
            new PasswordMismatchException();

    private PasswordMismatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}