package com.challenge.prices_challenge.application.controller.price;

import com.challenge.prices_challenge.application.controller.price.response.PriceInfoResponse;
import com.challenge.prices_challenge.application.controller.response.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;

@Tag(name = "Price")
public interface PriceApi {

	@Operation(summary = "Get price for a given product, brand and date")
	@ApiResponse(responseCode = "200", description = "Get price info")
	@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
	ResponseEntity<PriceInfoResponse> getPrices(
		@Parameter(in = ParameterIn.QUERY, name = "productId", description = "Product ID from which the price is obtained") @RequestParam int productId,
		@Parameter(in = ParameterIn.QUERY, name = "brandId", description = "Brand ID from which the price is obtained") @RequestParam int brandId,
		@Parameter(in = ParameterIn.QUERY, name = "applicationDate", description = "Application date from which the price is obtained") @RequestParam LocalDateTime applicationDate
	) throws ExecutionException;

}
