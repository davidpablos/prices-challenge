package com.challenge.prices_challenge.domain.model.price;

import com.challenge.prices_challenge.builder.Builder;
import com.challenge.prices_challenge.builder.FakeClock;

public class PriceBuilder extends Builder<Price> {

	@Override
	public Price build(int index) {
		return new Price(
            (long) index,
            index + 2L,
            FakeClock.dateTime(index),
            FakeClock.dateTime(index + 1),
            index + 3,
            index + 4,
            index + 5,
            index + 6,
            "::currency-" + index + "::"
        );
	}

}