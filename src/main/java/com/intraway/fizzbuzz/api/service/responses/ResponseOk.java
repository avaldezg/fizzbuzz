package com.intraway.fizzbuzz.api.service.responses;

public class ResponseOk extends Response {
	String code;
	String description;
	String list;

	public ResponseOk() {
		super();

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "ResponseOk [timestamp=" + super.toString() + ", code=" + code + ", description="
				+ description + ", list="+list;

	}
}
