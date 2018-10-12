package com.signet.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ValidationException extends RuntimeException {

	@Getter
	private String field;

	@Getter
	private String reason;
	
	@Getter
	private String errorCode;
	
}
