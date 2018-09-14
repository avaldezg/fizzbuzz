package com.intraway.fizzbuzz.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ApplicationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3505382872101232435L;

	public ApplicationException() {
		
	}
	public ApplicationException(String message) {
		super(message);
		
	}

}
