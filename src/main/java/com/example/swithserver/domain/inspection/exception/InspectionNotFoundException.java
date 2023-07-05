package com.example.swithserver.domain.inspection.exception;

import com.example.swithserver.domain.inspection.exception.error.InspectionErrorCode;
import com.example.swithserver.global.error.CustomException;

public class InspectionNotFoundException extends CustomException {

	public final static InspectionNotFoundException EXCEPTION = new InspectionNotFoundException();

	public InspectionNotFoundException() {
		super(InspectionErrorCode.INSPECTION_NOT_FOUND);
	}
}
