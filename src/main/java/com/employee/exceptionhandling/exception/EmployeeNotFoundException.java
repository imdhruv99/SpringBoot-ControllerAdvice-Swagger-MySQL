package com.employee.exceptionhandling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5655988716474190170L;
	
	public EmployeeNotFoundException(String exception) {
		super(exception);
	}
	

}
