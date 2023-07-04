package com.example.swithserver.global.exception;


import com.example.swithserver.global.error.CustomException;
import com.example.swithserver.global.error.ErrorCode;

public class InvalidJwtException extends CustomException {

    public static final CustomException EXCEPTION =
            new InvalidJwtException();

    private InvalidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }
}