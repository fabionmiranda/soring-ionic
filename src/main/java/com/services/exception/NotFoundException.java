package com.services.exception;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	//construtor
	public NotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}


	
}
