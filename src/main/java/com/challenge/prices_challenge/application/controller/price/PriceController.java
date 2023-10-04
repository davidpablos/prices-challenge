package com.challenge.prices_challenge.application.controller.price;

import com.challenge.prices_challenge.application.controller.price.response.PriceInfoResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/prices")
public class PriceController implements PriceApi {

	@Override
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PriceInfoResponse> getPrices(
		@RequestParam("productId") int productId,
		@RequestParam("brandId") int brandId,
		@RequestParam("applicationDate") LocalDateTime applicationDate
	) throws ExecutionException {
		return null;
	}

}
