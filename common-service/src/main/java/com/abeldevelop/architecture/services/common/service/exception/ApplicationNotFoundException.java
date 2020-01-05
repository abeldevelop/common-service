package com.abeldevelop.architecture.services.common.service.exception;

import java.util.List;

import com.abeldevelop.architecture.library.exception.client.NotFoundException;

public class ApplicationNotFoundException extends NotFoundException {

	private static final long serialVersionUID = -3086561586413180261L;

	public ApplicationNotFoundException(String message) {
		super(message);
	}

	public ApplicationNotFoundException(String message, List<Object> arguments) {
		super(message, arguments);
	}
	
	public ApplicationNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ApplicationNotFoundException(String message, List<Object> arguments, Throwable cause) {
		super(message, arguments, cause);
	}
}
