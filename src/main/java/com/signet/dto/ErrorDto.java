package com.signet.dto;

import lombok.Data;

@Data
public class ErrorDto {

	protected String code;

	protected String field;

	protected String message;
	
	protected String errorValue;
	
	public ErrorDto() {
		
	}
	
	public ErrorDto(String code, String field, String message) {
		this.code = code;
		this.field = field;
		this.message = message;
	}
	
	public ErrorDto(String code, String field, String message, String errorValue) {
		this.code = code;
		this.field = field;
		this.message = message;
		this.errorValue = errorValue;
	}

}
