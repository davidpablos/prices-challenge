package com.challenge.prices_challenge.domain.model.price;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Price {

	private final Long id;
	private final long brandId;
	private final LocalDateTime startDate;
	private final LocalDateTime endDate;
	private final int priceList;
	private final long productId;
	private final int priority;
	private final double price;
	private final String currency;

}
