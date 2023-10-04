package com.challenge.prices_challenge.application.controller.price;

import com.challenge.prices_challenge.application.controller.price.response.PriceInfoResponse;
import com.challenge.prices_challenge.builder.FakeClock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class PriceControllerTest {

	@InjectMocks
	private PriceController controller;

	@Test
	void when_get_prices_endpoint_is_invoked_then_response_is_returned() throws ExecutionException {
		ResponseEntity<PriceInfoResponse> response = this.controller.getPrices(1, 2, FakeClock.dateTime(3));

		assertNotNull(response);
	}

}