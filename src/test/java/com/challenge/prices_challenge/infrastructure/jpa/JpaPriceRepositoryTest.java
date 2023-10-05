package com.challenge.prices_challenge.infrastructure.jpa;

import com.challenge.prices_challenge.builder.FakeClock;
import com.challenge.prices_challenge.contract.Mapper;
import com.challenge.prices_challenge.domain.model.price.Price;
import com.challenge.prices_challenge.domain.model.price.PriceBuilder;
import com.challenge.prices_challenge.infrastructure.entity.price.PriceEntity;
import com.challenge.prices_challenge.infrastructure.entity.price.PriceEntityBuilder;
import com.challenge.prices_challenge.infrastructure.repository.SpringPriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JpaPriceRepositoryTest {

	@InjectMocks
	private JpaPriceRepository repository;

	@Mock
	private SpringPriceRepository springPriceRepository;

	@Mock
	private Mapper<PriceEntity, Price> priceMapper;

	@Test
	void when_find_method_is_executed_then_price_is_searched() {
		this.repository.find(2L, 3, FakeClock.dateTime(4));

		verify(this.springPriceRepository).findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
			2L,
			3,
			FakeClock.dateTime(4),
			FakeClock.dateTime(4)
		);
	}

	@Test
	void when_price_is_not_found_then_optional_empty_is_returned() {
		when(this.springPriceRepository.findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
			anyLong(),
			anyLong(),
			any(),
			any()
		)).thenReturn(Optional.empty());

		Optional<Price> price = this.repository.find(2L, 3, FakeClock.dateTime(4));

		assertTrue(price.isEmpty());
		verifyNoInteractions(this.priceMapper);
	}

	@Test
	void when_price_is_found_then_price_is_mapped() {
		when(this.springPriceRepository.findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
			anyLong(),
			anyLong(),
			any(),
			any()
		)).thenReturn(Optional.of(new PriceEntityBuilder().build(4)));

		this.repository.find(2L, 3, FakeClock.dateTime(4));

		verify(this.priceMapper).map(new PriceEntityBuilder().build(4));
	}

	@Test
	void when_price_is_mapped_then_it_is_returned() {
		when(this.springPriceRepository.findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
			anyLong(),
			anyLong(),
			any(),
			any()
		)).thenReturn(Optional.of(new PriceEntityBuilder().build(4)));
		when(this.priceMapper.map(any())).thenReturn(new PriceBuilder().build(3));

		Optional<Price> price = this.repository.find(2L, 3, FakeClock.dateTime(4));

		assertEquals(Optional.of(new PriceBuilder().build(3)), price);
	}

}