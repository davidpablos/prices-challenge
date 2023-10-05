package com.challenge.prices_challenge.infrastructure.entity.price;

import com.challenge.prices_challenge.builder.FakeClock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceEntityTest {

	@Test
	void when_entity_is_created_then_data_can_be_retrieved() {
		PriceEntity entity = new PriceEntity()
			.setId(22L)
			.setBrandId(3)
			.setStartDate(FakeClock.dateTime(2))
			.setEndDate(FakeClock.dateTime(3))
			.setPriceList(4)
			.setProductId(5)
			.setPriority(6)
			.setPrice(7.7)
			.setCurrency("::currency::");

		assertEquals(22L, entity.getId());
		assertEquals(3, entity.getBrandId());
		assertEquals(FakeClock.dateTime(2), entity.getStartDate());
		assertEquals(FakeClock.dateTime(3), entity.getEndDate());
		assertEquals(4, entity.getPriceList());
		assertEquals(5, entity.getProductId());
		assertEquals(6, entity.getPriority());
		assertEquals(7.7, entity.getPrice());
		assertEquals("::currency::", entity.getCurrency());
	}

}