package com.signet.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class NotFoundException extends RuntimeException {

	@Getter
	private String field;

	@Getter
	private String value;

}
