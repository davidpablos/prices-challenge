package com.challenge.prices_challenge.infrastructure.jpa;

import com.challenge.prices_challenge.contract.Mapper;
import com.challenge.prices_challenge.domain.model.price.Price;
import com.challenge.prices_challenge.domain.repository.PriceRepository;
import com.challenge.prices_challenge.infrastructure.entity.price.PriceEntity;
import com.challenge.prices_challenge.infrastructure.repository.SpringPriceRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
public class JpaPriceRepository implements PriceRepository {

	private final SpringPriceRepository springPriceRepository;
	private final Mapper<PriceEntity, Price> priceMapper;

	@Override
	public Optional<Price> find(long productId, long brandId, LocalDateTime applicationDate) {
		return this.springPriceRepository.findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
			productId,
			brandId,
			applicationDate,
			applicationDate
		).map(this.priceMapper::map);
	}

}
