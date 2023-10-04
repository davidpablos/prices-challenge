package com.challenge.prices_challenge.application.controller.response;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ErrorResponseTest {

	@Test
	void when_error_response_then_data_can_be_retrieved() {
		ErrorResponse errorResponse = new ErrorResponse("::error-message::");

		assertEquals("::error-message::", errorResponse.getMessage());
	}
}