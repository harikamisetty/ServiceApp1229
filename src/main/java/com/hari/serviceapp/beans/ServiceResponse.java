package com.hari.serviceapp.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String status;
	private String redirect;
	private JsonNode payload;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRedirect() {
		return redirect;
	}
	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}
	public JsonNode getPayload() {
		return payload;
	}
	public void setPayload(JsonNode payload) {
		this.payload = payload;
	}
}
