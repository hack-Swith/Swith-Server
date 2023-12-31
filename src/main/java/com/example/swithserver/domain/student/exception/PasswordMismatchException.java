package com.example.swithserver.domain.student.exception;


import com.example.swithserver.domain.student.exception.error.StudentErrorCode;
import com.example.swithserver.global.error.CustomException;

public class PasswordMismatchException extends CustomException {
    public static final CustomException EXCEPTION =
            new PasswordMismatchException();

    private PasswordMismatchException() {
        super(StudentErrorCode.PASSWORD_MISMATCH);
    }
}