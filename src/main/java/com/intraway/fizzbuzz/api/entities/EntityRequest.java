package com.intraway.fizzbuzz.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "request")
public class EntityRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2277510349083554078L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String method;
	private String parametes;
	private Date requestDate;
	
	@OneToOne(mappedBy = "request")
	private EntityResponse response;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public EntityRequest() {

	}

	public EntityRequest(String parametes) {
		super();
		this.parametes = parametes;
	}

	public String getParametes() {
		return parametes;
	}

	public void setParametes(String parametes) {
		this.parametes = parametes;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public EntityResponse getResponse() {
		return response;
	}

	public void setResponse(EntityResponse response) {
		this.response = response;
	}

}
