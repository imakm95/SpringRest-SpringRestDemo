package com.ashwani.sprin_rest_demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ashwani.sprin_rest_demo.exception.StudentNotFoundException;
import com.ashwani.sprin_rest_demo.pojo.StudentErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc)  {
		StudentErrorResponse response = new StudentErrorResponse();
		response.setStatusCode(HttpStatus.NOT_FOUND.value());
		response.setMessage(exc.getMessage());
		response.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<StudentErrorResponse>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc)  {
		StudentErrorResponse response = new StudentErrorResponse();
		response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		response.setMessage(exc.getCause().toString());
		response.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<StudentErrorResponse>(response,HttpStatus.BAD_REQUEST);
	}

}
