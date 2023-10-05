package com.challenge.prices_challenge.application.bean;

import com.challenge.prices_challenge.application.controller.price.response.PriceResponse;
import com.challenge.prices_challenge.application.controller.price.response.PriceResponseMapper;
import com.challenge.prices_challenge.contract.Mapper;
import com.challenge.prices_challenge.domain.model.price.Price;
import com.challenge.prices_challenge.infrastructure.entity.price.PriceEntity;
import com.challenge.prices_challenge.infrastructure.jpa.PriceMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mappers {

	@Bean
	public Mapper<PriceEntity, Price> priceMapper() {
		return new PriceMapper();
	}

	@Bean
	public Mapper<Price, PriceResponse> priceResponseMapper() {
		return new PriceResponseMapper();
	}

}
