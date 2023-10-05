package com.challenge.prices_challenge.application.bean;

import com.challenge.prices_challenge.contract.Mapper;
import com.challenge.prices_challenge.domain.model.price.Price;
import com.challenge.prices_challenge.domain.repository.PriceRepository;
import com.challenge.prices_challenge.infrastructure.entity.price.PriceEntity;
import com.challenge.prices_challenge.infrastructure.jpa.JpaPriceRepository;
import com.challenge.prices_challenge.infrastructure.repository.SpringPriceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Repository {

	@Bean
	public PriceRepository priceRepository(
		SpringPriceRepository springPriceRepository,
		Mapper<PriceEntity, Price> priceMapper
	) {
		return new JpaPriceRepository(springPriceRepository, priceMapper);
	}

}
