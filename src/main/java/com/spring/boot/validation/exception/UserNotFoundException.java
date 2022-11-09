package com.spring.boot.validation.exception;

public class UserNotFoundException extends Exception {
	
	public UserNotFoundException(String message) {
		super(message);
	}

}
