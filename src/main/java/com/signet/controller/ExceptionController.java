package com.signet.controller;

import static com.signet.constants.ErrorCodeConstants.INTERNAL_ERROR;
import static com.signet.constants.ErrorCodeConstants.NOT_FOUND;
import static com.signet.constants.ErrorCodeConstants.NOT_VALID;
import static com.signet.constants.ErrorCodeConstants.SCHEMA_NOT_VALID;

import java.util.ArrayList;
import java.util.List;

import org.everit.json.schema.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.signet.dto.ErrorDto;
import com.signet.dto.ValidationErrorDto;
import com.signet.exception.NotFoundException;
import com.signet.exception.SchemaValidationException;
import com.signet.schema.validation.ValidationConstants;
import com.signet.schema.validation.ValidationErrorDetail;


@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(SchemaValidationException.class)
	public ResponseEntity<List<ErrorDto>> handleSchemaValidationException(SchemaValidationException e) {
		final List<ErrorDto> errors = new ArrayList<>();
		for (ValidationErrorDetail validationErrorDetail : e.getValidationErrorDetails()) {
			final String reason;
			switch (validationErrorDetail.getErrorType()) {
				case ValidationConstants.REQUIRED:
					reason = "A value was not provided for the required field.";
					break;
				case ValidationConstants.MAX_LENGTH:
					reason = "The value provided exceeded the maximum field length.";
					break;
				case ValidationConstants.MINIMUM:
					reason = "The value provided was below the minimum allowed.";
					break;
				case ValidationConstants.MAXIMUM:
					reason = "The value provided was above the maximum allowed.";
					break;
				case ValidationConstants.PATTERN:
					reason = "The value provided did not match the allowed pattern.";
					break;
				case ValidationConstants.INVALID:
					reason = "The node provided is not part of the allowed schema.";
					break;
				case ValidationConstants.NOT_NUMBER:
					reason = "The value provided was not a number.";
					break;
				case ValidationConstants.NOT_STRING:
					reason = "The value provided was not a string";
					break;
				default:
					reason = "The provided value was not valid for the schema.";
					break;
			}
			errors.add(new ErrorDto(SCHEMA_NOT_VALID, validationErrorDetail.getNode(), reason));
		}
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<List<ErrorDto>> handleNotFoundException(NotFoundException e) {
		final String message = "The provided ID '" + e.getValue() + "' was not found.";
		final List<ErrorDto> errorDto = new ArrayList<>() ;
		errorDto.add(new ErrorDto(NOT_FOUND, e.getField(), message));
		return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<List<ErrorDto>> handleValidationException(ValidationException e) {
		final List<ErrorDto> errors = new ArrayList<>();
		errors.add(new ErrorDto(NOT_VALID, e.getFieldName() ,e.getErrorMessage()));
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<List<ErrorDto>> handleInternalErrorException(Exception e) {
		final List<ErrorDto> errorDto = new ArrayList<>();
		errorDto.add(new ErrorDto(INTERNAL_ERROR, "", "Something went wrong"));
		return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
