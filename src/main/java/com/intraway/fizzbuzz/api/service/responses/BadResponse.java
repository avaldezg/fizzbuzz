package com.intraway.fizzbuzz.api.service.responses;

public class BadResponse extends Response {

	String status;
	String error;
	String exception;
	String message;
	String path;

	public BadResponse() {

	}

	public BadResponse(String status, String error, String exception, String message, String path) {
		super();
		this.status = status;
		this.error = error;
		this.exception = exception;
		this.message = message;
		this.path = path;
	}
	public BadResponse(String message) {
		super();
		this.message=message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "BadRequest [timestamp=" + super.toString() + ", status=" + status + ", error=" + error + ", exception="
				+ exception + ", message=" + message + ", path=" + path + "]";
	}
}