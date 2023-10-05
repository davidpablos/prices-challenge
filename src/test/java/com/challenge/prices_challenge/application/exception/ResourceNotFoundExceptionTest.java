package com.challenge.prices_challenge.application.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResourceNotFoundExceptionTest {

	@Test
	void when_exception_is_created_then_message_can_be_retrieved() {
		Throwable cause = new Throwable("::message::");

		ResourceNotFoundException exception = new ResourceNotFoundException(cause);

		assertEquals(cause, exception.getCause());
	}

}