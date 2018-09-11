package com.intraway.fizzbuzz.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.intraway.fizzbuzz.api.service.responses.BadResponse;

@ControllerAdvice
@RestController
public class FizzbuzzResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<BadResponse> handleAllExceptions(Exception ex, WebRequest request) {
		BadResponse exceptionResponse = new BadResponse(ex.getMessage());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(BadRequestException.class)
	public final ResponseEntity<BadResponse> handleNotFoundException(BadRequestException ex, WebRequest request) {
		BadResponse exceptionResponse = new BadResponse(ex.getStatus(), ex.getError(),ex.getException(),ex.getMessage(),ex.getPath());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

}
