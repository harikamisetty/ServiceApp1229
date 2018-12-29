package com.hari.serviceapp.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseEntity<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private T response;
	private int statusCode;
	
	public ResponseEntity(T response) {
		super();
		setResponse(response);
	}
	
	public T getResponse() {
		return response;
	}
	public void setResponse(T response) {
		this.response = response;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
