package br.com.postechfiap.jlapp.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntityException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 3275864983968991022L;

	public UnprocessableEntityException() {
		super();
	}

	public UnprocessableEntityException(String message) {
		super(message);
	}

	public UnprocessableEntityException(Throwable cause) {
		super(cause);
	}

	public UnprocessableEntityException(String message, Throwable cause) {
		super(message, cause);
	}
}
