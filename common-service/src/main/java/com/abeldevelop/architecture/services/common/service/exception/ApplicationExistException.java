package com.abeldevelop.architecture.services.common.service.exception;

import java.util.List;

import com.abeldevelop.architecture.library.exception.client.BadRequestException;

public class ApplicationExistException extends BadRequestException {

	private static final long serialVersionUID = -3086561586413180261L;

	public ApplicationExistException(String message) {
		super(message);
	}

	public ApplicationExistException(String message, List<Object> arguments) {
		super(message, arguments);
	}
	
	public ApplicationExistException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ApplicationExistException(String message, List<Object> arguments, Throwable cause) {
		super(message, arguments, cause);
	}
}
