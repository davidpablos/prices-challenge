package com.challenge.prices_challenge.domain.repository;

import com.challenge.prices_challenge.domain.model.price.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository {

	Optional<Price> find(long productId, long brandId, LocalDateTime applicationDate);

}
