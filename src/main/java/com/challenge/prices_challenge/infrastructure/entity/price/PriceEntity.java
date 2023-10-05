package com.challenge.prices_challenge.infrastructure.entity.price;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@Table(name = "price")
@Data
@Accessors(chain = true)
public class PriceEntity {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native")
	private Long id;

	@Column(name = "brand_id", nullable = false)
	private long brandId;

	@Column(name = "start_date", nullable = false)
	private LocalDateTime startDate;

	@Column(name = "end_date", nullable = false)
	private LocalDateTime endDate;

	@Column(name = "price_list", nullable = false)
	private int priceList;

	@Column(name = "product_id", nullable = false)
	private long productId;

	@Column(name = "priority", nullable = false)
	private int priority;

	@Column(name = "price", nullable = false)
	private double price;

	@Column(name = "currency", nullable = false)
	private String currency;

}
