package com.hnt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BaseController {

	public BaseController() {
		super();
	}

	
	@ResponseStatus(code = HttpStatus.FORBIDDEN)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	Map<String, String> handleException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldname = ((FieldError) error).getField();
			String message = ((FieldError) error).getDefaultMessage();
			errors.put(fieldname, message);
		});
		return errors;
	}
	
	@ResponseStatus(code = HttpStatus.EXPECTATION_FAILED)
	@ExceptionHandler(Exception.class)
	void handleAllException(Exception ex) {
		
	}

}