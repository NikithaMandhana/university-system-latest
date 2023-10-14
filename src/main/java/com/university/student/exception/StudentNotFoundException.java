package com.university.student.exception;

public class StudentNotFoundException extends RuntimeException{

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public StudentNotFoundException(String message) {
		super(message);
		this.message = message;
	}
	
	public StudentNotFoundException() {
	}
}
