package com.challenge.prices_challenge.application.controller.price.response;

import com.challenge.prices_challenge.builder.FakeClock;
import com.challenge.prices_challenge.domain.model.price.Price;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PriceResponseMapperTest {

	@InjectMocks
	private PriceResponseMapper mapper;

	@Test
	void when_mapper_is_used_then_response_is_returned() {
		PriceResponse response = this.mapper.map(
			new Price(
				1L,
				2,
				FakeClock.dateTime(4),
				FakeClock.dateTime(5),
				3,
				4,
				5,
				6.6,
				"::currency"
			)
		);

		assertEquals(4, response.getProductId());
		assertEquals(2, response.getBrandId());
		assertEquals(3, response.getPriceList());
		assertEquals(FakeClock.dateTime(4), response.getStartDate());
		assertEquals(FakeClock.dateTime(5), response.getEndDate());
		assertEquals(6.6, response.getPrice());
	}
}