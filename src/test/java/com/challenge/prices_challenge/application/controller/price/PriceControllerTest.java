package com.challenge.prices_challenge.application.controller.price;

import com.challenge.prices_challenge.application.controller.price.response.PriceResponse;
import com.challenge.prices_challenge.application.controller.price.response.PriceResponseBuilder;
import com.challenge.prices_challenge.application.exception.ResourceNotFoundException;
import com.challenge.prices_challenge.builder.FakeClock;
import com.challenge.prices_challenge.contract.Mapper;
import com.challenge.prices_challenge.domain.exception.PriceNotFoundException;
import com.challenge.prices_challenge.domain.model.price.Price;
import com.challenge.prices_challenge.domain.model.price.PriceBuilder;
import com.challenge.prices_challenge.domain.use_case.price.FindPriceWithFilters;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceControllerTest {

	@InjectMocks
	private PriceController controller;

	@Mock
	private FindPriceWithFilters findPriceWithFilters;

	@Mock
	private Mapper<Price, PriceResponse> priceResponseMapper;

	@Test
	void when_get_prices_endpoint_is_invoked_then_price_are_searched() throws ResourceNotFoundException, PriceNotFoundException {
		this.controller.getPrices(1, 2, FakeClock.dateTime(3));

		verify(this.findPriceWithFilters).execute(1, 2, FakeClock.dateTime(3));
	}

	@Test
	void when_price_is_not_found_then_exception_is_thrown() throws PriceNotFoundException {
		when(this.findPriceWithFilters.execute(anyLong(), anyLong(), any())).thenThrow(PriceNotFoundException.class);

		assertThrows(
			ResourceNotFoundException.class,
			() -> this.controller.getPrices(1, 2, FakeClock.dateTime(3))
		);
		verifyNoInteractions(this.priceResponseMapper);
	}

	@Test
	void when_price_is_retrieved_then_response_is_mapped() throws ResourceNotFoundException, PriceNotFoundException {
		when(this.findPriceWithFilters.execute(anyLong(), anyLong(), any())).thenReturn(new PriceBuilder().build(4));

		this.controller.getPrices(1, 2, FakeClock.dateTime(3));

		verify(this.priceResponseMapper).map(new PriceBuilder().build(4));
	}

	@Test
	void when_price_info_response_is_mapped_then_it_is_returned() throws ResourceNotFoundException {
		when(this.priceResponseMapper.map(any())).thenReturn(new PriceResponseBuilder().build(4));

		ResponseEntity<PriceResponse> response = this.controller.getPrices(1, 2, FakeClock.dateTime(3));

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(
			new PriceResponseBuilder().build(4),
			response.getBody()
		);
	}

}