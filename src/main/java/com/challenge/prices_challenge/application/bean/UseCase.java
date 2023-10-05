package com.challenge.prices_challenge.application.bean;

import com.challenge.prices_challenge.domain.repository.PriceRepository;
import com.challenge.prices_challenge.domain.use_case.price.FindPriceWithFilters;
import com.challenge.prices_challenge.domain.use_case.price.FindPriceWithFiltersUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCase {

	@Bean
	public FindPriceWithFilters findPriceWithFilters(PriceRepository priceRepository) {
		return new FindPriceWithFiltersUseCase(priceRepository);
	}

}
