package com.project.comments.model;

import org.springframework.http.HttpStatus;

public class CommonResponse {
	
	private HttpStatus status;
	private Object data;
	private String message;
	private String error;
	
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public CommonResponse(HttpStatus status, Object data, String message, String error) {
		super();
		this.status = status;
		this.data = data;
		this.message = message;
		this.error = error;
	}
	public CommonResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
