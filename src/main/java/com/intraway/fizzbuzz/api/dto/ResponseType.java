package com.intraway.fizzbuzz.api.dto;

public enum ResponseType {
	RESPONSE_OK("OK"), BAD_REQUEST("BAD_REQUEST"), NOT_FOUND("NOT_FOUND");
	private String name;

	ResponseType(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
