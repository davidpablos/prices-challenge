package com.challenge.prices_challenge.application.controller.price.response;

import com.challenge.prices_challenge.builder.FakeClock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceInfoResponseTest {

	@Test
	void when_response_is_created_then_data_can_be_retrieved() {
		PriceInfoResponse response = new PriceInfoResponse(
			35455,
			1,
			3,
			FakeClock.dateTime(2),
			FakeClock.dateTime(4),
			30.50
		);

		assertEquals(35455, response.getProductId());
		assertEquals(1, response.getBrandId());
		assertEquals(3, response.getPriceList());
		assertEquals(FakeClock.dateTime(2), response.getStartDate());
		assertEquals(FakeClock.dateTime(4), response.getEndDate());
		assertEquals(30.50, response.getPrice());
	}

}