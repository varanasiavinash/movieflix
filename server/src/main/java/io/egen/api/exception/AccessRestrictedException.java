package io.egen.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class AccessRestrictedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccessRestrictedException(String message) {
		super(message);
	}

	public AccessRestrictedException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
