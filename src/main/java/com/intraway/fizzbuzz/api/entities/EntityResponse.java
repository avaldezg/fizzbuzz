package com.intraway.fizzbuzz.api.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.intraway.fizzbuzz.api.dto.ResponseType;

@Entity(name = "response")
public class EntityResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5204222889359285010L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne/*(cascade = CascadeType.ALL)*/
	@JoinColumn(name = "request_id")
	private EntityRequest request;
	
	private Timestamp timestamp;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition="varchar(20)")
	private ResponseType type;
	
	private String message;
	// in this field you can save the list if the answer is ok or the path and the
	// exception otherwise
	private String additionalData;
	private String code;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EntityRequest getRequest() {
		return request;
	}

	public void setRequest(EntityRequest request) {
		this.request = request;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	
	public ResponseType getType() {
		return type;
	}

	public void setType(ResponseType type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(length = 3000)
	public String getAdditionalData() {
		return additionalData;
	}

	public void setAdditionalData(String additionalData) {
		this.additionalData = additionalData;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
