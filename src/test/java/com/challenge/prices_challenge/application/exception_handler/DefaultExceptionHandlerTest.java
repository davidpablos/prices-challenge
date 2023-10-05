package com.challenge.prices_challenge.application.exception_handler;

import com.challenge.prices_challenge.application.controller.response.ErrorResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class DefaultExceptionHandlerTest {

	@InjectMocks
	private DefaultExceptionHandler handler;

	@Test
	void when_unknown_exception_occurred_then_internal_server_error_code_is_returned() {
		ResponseEntity<ErrorResponse> response = this.handler.handleException(new Exception("::message::"));

		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
		assertEquals("Unexpected server error. Contact your administrator", response.getBody().getMessage());
	}

}