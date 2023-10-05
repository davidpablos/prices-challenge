package com.challenge.prices_challenge.domain.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceNotFoundExceptionTest {

	@Test
	void when_exception_is_created_then_message_can_be_retrieved() {
		PriceNotFoundException exception = new PriceNotFoundException("::message::");

		assertEquals("::message::", exception.getMessage());
	}

}