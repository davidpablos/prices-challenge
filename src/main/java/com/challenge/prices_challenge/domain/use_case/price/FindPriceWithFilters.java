package com.challenge.prices_challenge.domain.use_case.price;

import com.challenge.prices_challenge.domain.exception.PriceNotFoundException;
import com.challenge.prices_challenge.domain.model.price.Price;

import java.time.LocalDateTime;

public interface FindPriceWithFilters {

	Price execute(long productId, long brandId, LocalDateTime applicationDate) throws PriceNotFoundException;

}
