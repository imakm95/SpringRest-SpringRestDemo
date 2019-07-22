package com.ashwani.sprin_rest_demo.pojo;

public class StudentErrorResponse {
	private Integer statusCode;
	private String message;
	private Long timeStamp;
	public StudentErrorResponse(Integer statusCode, String message, Long timeStamp) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.timeStamp = timeStamp;
	}
	public StudentErrorResponse() {
		super();
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
