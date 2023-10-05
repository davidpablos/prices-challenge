package com.challenge.prices_challenge.application.controller.price;

import com.challenge.prices_challenge.application.controller.price.response.PriceResponse;
import com.challenge.prices_challenge.application.exception.ResourceNotFoundException;
import com.challenge.prices_challenge.contract.Mapper;
import com.challenge.prices_challenge.domain.exception.PriceNotFoundException;
import com.challenge.prices_challenge.domain.model.price.Price;
import com.challenge.prices_challenge.domain.use_case.price.FindPriceWithFilters;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/prices")
@RequiredArgsConstructor
public class PriceController implements PriceApi {

	private final FindPriceWithFilters findPriceWithFilters;
	private final Mapper<Price, PriceResponse> priceResponseMapper;

	@Override
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PriceResponse> getPrices(
		@RequestParam("productId") long productId,
		@RequestParam("brandId") long brandId,
		@RequestParam("applicationDate") LocalDateTime applicationDate
	) throws ResourceNotFoundException {
		Price price;
		try {
			price = this.findPriceWithFilters.execute(productId, brandId, applicationDate);
		} catch(PriceNotFoundException e) {
			throw new ResourceNotFoundException(e);
		}

		return ResponseEntity.ok(this.priceResponseMapper.map(price));
	}

}
