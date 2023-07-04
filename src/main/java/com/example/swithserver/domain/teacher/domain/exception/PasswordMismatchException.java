package com.example.swithserver.domain.teacher.domain.exception;


import com.example.swithserver.domain.teacher.domain.exception.error.TeacherErrorCode;
import com.example.swithserver.global.error.CustomException;

public class PasswordMismatchException extends CustomException {
    public static final CustomException EXCEPTION =
            new PasswordMismatchException();

    private PasswordMismatchException() {
        super(TeacherErrorCode.PASSWORD_MISMATCH);
    }
}