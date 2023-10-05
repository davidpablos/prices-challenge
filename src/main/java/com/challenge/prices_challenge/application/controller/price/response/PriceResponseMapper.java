package com.challenge.prices_challenge.application.controller.price.response;

import com.challenge.prices_challenge.contract.Mapper;
import com.challenge.prices_challenge.domain.model.price.Price;

public class PriceResponseMapper implements Mapper<Price, PriceResponse> {

	@Override
	public PriceResponse map(Price price) {
		return new PriceResponse(
			price.getProductId(),
			price.getBrandId(),
			price.getPriceList(),
			price.getStartDate(),
			price.getEndDate(),
			price.getPrice(),
			price.getCurrency()
		);
	}

}
