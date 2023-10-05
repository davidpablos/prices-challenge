package com.challenge.prices_challenge.domain.use_case.price;

import com.challenge.prices_challenge.builder.FakeClock;
import com.challenge.prices_challenge.domain.exception.PriceNotFoundException;
import com.challenge.prices_challenge.domain.model.price.Price;
import com.challenge.prices_challenge.domain.model.price.PriceBuilder;
import com.challenge.prices_challenge.domain.repository.PriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindPriceWithFiltersUseCaseTest {

	@InjectMocks
	private FindPriceWithFiltersUseCase useCase;

	@Mock
	private PriceRepository priceRepository;

	@Test
	void when_execute_then_price_is_searched() throws PriceNotFoundException {
		when(this.priceRepository.find(anyLong(), anyLong(), any())).thenReturn(Optional.of(new PriceBuilder().build(3)));

		this.useCase.execute(1, 2, FakeClock.dateTime(3));

		verify(this.priceRepository).find(1, 2, FakeClock.dateTime(3));
	}

	@Test
	void when_price_is_not_found_for_the_given_filters_then_exception_is_thrown() {
		when(this.priceRepository.find(anyLong(), anyLong(), any())).thenReturn(Optional.empty());

		assertThrows(
			PriceNotFoundException.class,
			() -> this.useCase.execute(1, 2, FakeClock.dateTime(3))
		);
	}

	@Test
	void when_price_is_found_for_the_given_filters_then_it_is_returned() throws PriceNotFoundException {
		when(this.priceRepository.find(anyLong(), anyLong(), any())).thenReturn(Optional.of(new PriceBuilder().build(3)));

		Price price = this.useCase.execute(1, 2, FakeClock.dateTime(3));

		assertEquals(new PriceBuilder().build(3), price);
	}

}