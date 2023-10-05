package com.challenge.prices_challenge.application.exception_handler;

import com.challenge.prices_challenge.application.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ResourceNotFoundExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Void> handleResourceNotFoundException(ResourceNotFoundException ex) {
		log.error("Resource not found exception", ex);

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}