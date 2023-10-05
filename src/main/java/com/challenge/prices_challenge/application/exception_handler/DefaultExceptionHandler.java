package com.challenge.prices_challenge.application.exception_handler;

import com.challenge.prices_challenge.application.controller.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class DefaultExceptionHandler {

	private static final String MSG_INTERNAL_SERVER_ERROR = "Unexpected server error. Contact your administrator";

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception ex) {
		log.error("Unexpected exception", ex);

		return new ResponseEntity<>(new ErrorResponse(MSG_INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
