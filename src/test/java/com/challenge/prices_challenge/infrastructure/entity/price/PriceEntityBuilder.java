package com.challenge.prices_challenge.infrastructure.entity.price;

import com.challenge.prices_challenge.builder.Builder;
import com.challenge.prices_challenge.builder.FakeClock;

public class PriceEntityBuilder extends Builder<PriceEntity> {

	@Override
	public PriceEntity build(int index) {
		return new PriceEntity()
			.setId((long)index)
			.setBrandId(index)
			.setStartDate(FakeClock.dateTime(index))
			.setEndDate(FakeClock.dateTime(index + 1))
			.setPriceList(index + 2)
			.setProductId(index + 3)
			.setPriority(index + 4)
			.setPrice(index + 5)
			.setCurrency("::currency-" + index + "::");
	}

}