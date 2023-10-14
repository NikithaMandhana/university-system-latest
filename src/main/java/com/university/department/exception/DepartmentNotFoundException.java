package com.university.department.exception;

public class DepartmentNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public DepartmentNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	public DepartmentNotFoundException() {
		super();
	}

	public synchronized String getMessage() {
		return message;
	}

	public synchronized void setMessage(String message) {
		this.message = message;
	}
	
	
}
