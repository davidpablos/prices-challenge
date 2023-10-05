package com.challenge.prices_challenge.infrastructure.repository;

import com.challenge.prices_challenge.infrastructure.entity.price.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface SpringPriceRepository extends JpaRepository<PriceEntity, Long> {

	Optional<PriceEntity> findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
		long productId,
		long brandId,
		LocalDateTime dateTime,
		LocalDateTime endDate
	);

}
