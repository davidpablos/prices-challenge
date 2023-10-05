package com.challenge.prices_challenge.application.controller.price.response;

import com.challenge.prices_challenge.builder.Builder;
import com.challenge.prices_challenge.builder.FakeClock;

public class PriceResponseBuilder extends Builder<PriceResponse> {

	@Override
	public PriceResponse build(int index) {
		return new PriceResponse(
			index,
			index * 2L,
			index * 3,
			FakeClock.dateTime(index),
			FakeClock.dateTime(index + 1),
			index * 4,
			"::currency-" + index + "::"
		);
	}

}