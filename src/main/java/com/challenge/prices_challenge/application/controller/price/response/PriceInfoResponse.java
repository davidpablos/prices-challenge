package com.challenge.prices_challenge.application.controller.price.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PriceInfoResponse {

	@Schema(description = "Product id", example = "35455", requiredMode = Schema.RequiredMode.REQUIRED)
	private final int productId;

	@Schema(description = "Brand id", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
	private final int brandId;

	@Schema(description = "Price fare id", example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
	private final int priceList;

	@Schema(description = "Price's start date", example = "2020-06-14-15.00.00", requiredMode = Schema.RequiredMode.REQUIRED)
	private final LocalDateTime startDate;

	@Schema(description = "Price's end date", example = "2020-06-14-18.30.00", requiredMode = Schema.RequiredMode.REQUIRED)
	private final LocalDateTime endDate;

	@Schema(description = "Price", example = "30.2", requiredMode = Schema.RequiredMode.REQUIRED)
	private final double price;

}
