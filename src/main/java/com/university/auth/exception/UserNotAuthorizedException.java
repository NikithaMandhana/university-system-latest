package com.university.auth.exception;

public class UserNotAuthorizedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3104496415484649775L;

	private String message;
	
	public UserNotAuthorizedException(String message) {
		super(message);
		this.setMessage(message);
	}
	
	public UserNotAuthorizedException() {
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
