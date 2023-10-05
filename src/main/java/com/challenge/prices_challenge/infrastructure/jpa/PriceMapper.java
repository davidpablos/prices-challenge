package com.challenge.prices_challenge.infrastructure.jpa;

import com.challenge.prices_challenge.contract.Mapper;
import com.challenge.prices_challenge.domain.model.price.Price;
import com.challenge.prices_challenge.infrastructure.entity.price.PriceEntity;

public class PriceMapper implements Mapper<PriceEntity, Price> {

	@Override
	public Price map(PriceEntity entity) {
		return new Price(
			entity.getId(),
			entity.getBrandId(),
			entity.getStartDate(),
			entity.getEndDate(),
			entity.getPriceList(),
			entity.getProductId(),
			entity.getPriority(),
			entity.getPrice(),
			entity.getCurrency()
		);
	}

}
