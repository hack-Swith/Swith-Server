package com.example.swithserver.global.jwt.exception;

import com.example.swithserver.global.error.CustomException;
import com.example.swithserver.global.jwt.exception.error.TokenErrorCode;

public class TokenUnauthorizedException extends CustomException {

	public final static TokenUnauthorizedException EXCEPTION = new TokenUnauthorizedException();

	public TokenUnauthorizedException() {
		super(TokenErrorCode.TOKEN_UNAUTHORIZED);
	}

}
