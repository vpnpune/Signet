package com.signet.controller;

import static com.signet.constants.ErrorCodeConstants.INTERNAL_ERROR;
import static com.signet.constants.ErrorCodeConstants.NOT_FOUND;
import static com.signet.constants.ErrorCodeConstants.NOT_VALID;
import static com.signet.constants.ErrorCodeConstants.SCHEMA_NOT_VALID;
import static com.signet.constants.ErrorCodeConstants.REQUIRED;
import static com.signet.constants.ErrorCodeConstants.MIN_LENGTH;
import static com.signet.constants.ErrorCodeConstants.MAX_LENGTH;

import java.util.ArrayList;
import java.util.List;

import org.everit.json.schema.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.signet.dto.ErrorDto;
import com.signet.exception.NotFoundException;


@ControllerAdvice
public class ExceptionController {

	private final static String VALIDATION_MESSAGE = "Validation failed";
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<List<ErrorDto>> handleNotFoundException(NotFoundException e) {
		final String message = "The provided ID '" + e.getValue() + "' was not found.";
		final List<ErrorDto> errorDto = new ArrayList<>() ;
		errorDto.add(new ErrorDto(NOT_FOUND, e.getField(), message));
		return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<List<ErrorDto>> handleValidationException(ValidationException e) {
		List<ValidationException> errorsList = e.getCausingExceptions();
		final List<ErrorDto> errors = new ArrayList<>();
		String fieldName = "";
		String keyword = "";
		String message = "";
		for(ValidationException err: errorsList) {
			fieldName = err.getPointerToViolation().substring(err.getPointerToViolation().indexOf('/')+1);
			if("#".equals(fieldName)) {
				fieldName = err.getMessage().substring(err.getMessage().indexOf('[')+1,err.getMessage().indexOf(']'));
			}
			keyword = err.getKeyword();
			
			switch(keyword) {
				case REQUIRED: 
					message = "Required field should not be empty.";
					break;
				case MIN_LENGTH:
					message = "Minimum length of data should be provided.";
					break;
				case MAX_LENGTH:
					message = "Maximum length of data should be provided.";
					break;
			}
			errors.add(new ErrorDto(SCHEMA_NOT_VALID, fieldName, message ,fieldName+ "." + err.getKeyword()));
		}		

		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<List<ErrorDto>> handleInternalErrorException(Exception e) {
		final List<ErrorDto> errorDto = new ArrayList<>();
		errorDto.add(new ErrorDto(INTERNAL_ERROR, "", "Something went wrong"));
		return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<ErrorDto>> handleMethodArgumentValications(MethodArgumentNotValidException e) {
		final List<ErrorDto> errorDto = new ArrayList<>();
		errorDto.add(new ErrorDto(e.getLocalizedMessage(), "", e.getMessage()));
		return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
