package com.challenge.prices_challenge.infrastructure.jpa;

import com.challenge.prices_challenge.builder.FakeClock;
import com.challenge.prices_challenge.domain.model.price.Price;
import com.challenge.prices_challenge.infrastructure.entity.price.PriceEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PriceMapperTest {

	@InjectMocks
	private PriceMapper mapper;

	@Test
	void when_mapper_is_used_then_price_is_returned() {
		Price price = this.mapper.map(
			new PriceEntity().setId(22L)
				.setBrandId(1L)
				.setStartDate(FakeClock.dateTime(2))
				.setEndDate(FakeClock.dateTime(3))
				.setPriceList(4)
				.setProductId(5)
				.setPriority(6)
				.setPrice(7.7)
				.setCurrency("::currency::")
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