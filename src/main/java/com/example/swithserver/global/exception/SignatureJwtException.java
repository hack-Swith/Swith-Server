package com.example.swithserver.global.exception;


import com.example.swithserver.global.error.CustomException;
import com.example.swithserver.global.error.ErrorCode;

public class SignatureJwtException extends CustomException {

    public static final CustomException EXCEPTION =
            new SignatureJwtException();

    private SignatureJwtException() {
        super(ErrorCode.SIGNATURE_JWT);
    }
}