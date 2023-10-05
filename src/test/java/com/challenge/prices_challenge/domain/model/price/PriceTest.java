package com.challenge.prices_challenge.domain.model.price;

import com.challenge.prices_challenge.builder.FakeClock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceTest {

	@Test
	void when_entity_is_created_then_data_can_be_retrieved() {
		Price price = new Price(
			22L,
			1L,
			FakeClock.dateTime(2),
			FakeClock.dateTime(3),
			4,
			5,
			6,
			7.7,
			"::currency::"
		);

		assertEquals(22L, price.getId());
		assertEquals(1L, price.getBrandId());
		assertEquals(FakeClock.dateTime(2), price.getStartDate());
		assertEquals(FakeClock.dateTime(3), price.getEndDate());
		assertEquals(4, price.getPriceList());
		assertEquals(5, price.getProductId());
		assertEquals(6, price.getPriority());
		assertEquals(7.7, price.getPrice());
		assertEquals("::currency::", price.getCurrency());
	}

}