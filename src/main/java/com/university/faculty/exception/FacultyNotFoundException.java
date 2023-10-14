package com.university.faculty.exception;

public class FacultyNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public FacultyNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	public FacultyNotFoundException() {
	}

	public synchronized String getMessage() {
		return message;
	}

	public synchronized void setMessage(String message) {
		this.message = message;
	}
}
