package com.challenge.prices_challenge.domain.use_case.price;

import com.challenge.prices_challenge.domain.exception.PriceNotFoundException;
import com.challenge.prices_challenge.domain.model.price.Price;
import com.challenge.prices_challenge.domain.repository.PriceRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class FindPriceWithFiltersUseCase implements FindPriceWithFilters {

	private final PriceRepository priceRepository;

	@Override
	public Price execute(long productId, long brandId, LocalDateTime applicationDate) throws PriceNotFoundException {
		return this.priceRepository.find(productId, brandId, applicationDate)
			.orElseThrow(() -> new PriceNotFoundException(
				String.format(
					"Cannot find price for product id %d, brand id %d, application date %s",
					productId, brandId, applicationDate)
			));
	}

}
