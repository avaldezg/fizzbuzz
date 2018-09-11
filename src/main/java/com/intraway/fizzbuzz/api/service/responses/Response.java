package com.intraway.fizzbuzz.api.service.responses;

import java.sql.Timestamp;

public class Response {
	

	private Timestamp timestamp;
	
	public Response() {
		this.timestamp = new Timestamp(System.currentTimeMillis());
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return String.valueOf(timestamp.getTime());
	}
	
}
