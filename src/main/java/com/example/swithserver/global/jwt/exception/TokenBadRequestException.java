package com.example.swithserver.global.jwt.exception;

import com.example.swithserver.global.error.CustomException;
import com.example.swithserver.global.jwt.exception.error.TokenErrorCode;

public class TokenBadRequestException extends CustomException {

	public final static TokenBadRequestException EXCEPTION = new TokenBadRequestException();

	public TokenBadRequestException() {
		super(TokenErrorCode.TOKEN_BAD_REQUEST);
	}

}
