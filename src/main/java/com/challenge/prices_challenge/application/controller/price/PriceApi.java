package com.challenge.prices_challenge.application.controller.price;

import com.challenge.prices_challenge.application.controller.price.response.PriceResponse;
import com.challenge.prices_challenge.application.controller.response.ErrorResponse;
import com.challenge.prices_challenge.application.exception.ResourceNotFoundException;
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

@Tag(name = "Price")
public interface PriceApi {

	@Operation(summary = "Get price for a given product, brand and date")
	@ApiResponse(responseCode = "200", description = "Get price info", content = @Content(schema = @Schema(implementation = PriceResponse.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
	@ApiResponse(responseCode = "404", description = "Resource not found", content = @Content)
	@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
	ResponseEntity<PriceResponse> getPrices(
		@Parameter(in = ParameterIn.QUERY, name = "productId", description = "Product ID from which the price is obtained", example = "35455") @RequestParam long productId,
		@Parameter(in = ParameterIn.QUERY, name = "brandId", description = "Brand ID from which the price is obtained", example = "1") @RequestParam long brandId,
		@Parameter(in = ParameterIn.QUERY, name = "applicationDate", description = "Application date from which the price is obtained", example = "2020-06-14T15:00:00") @RequestParam LocalDateTime applicationDate
	) throws ResourceNotFoundException;

}
