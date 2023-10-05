package com.challenge.prices_challenge.application.exception_handler;

import com.challenge.prices_challenge.application.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ResourceNotFoundExceptionHandlerTest {

	@InjectMocks
	private ResourceNotFoundExceptionHandler handler;

	@Test
	void when_the_request_is_not_found_then_not_found_code_is_returned() {
		ResponseEntity<Void> response = this.handler.handleResourceNotFoundException(
			new ResourceNotFoundException(new Throwable("::message::"))
		);

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

}