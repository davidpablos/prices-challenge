package com.challenge.prices_challenge.application.controller.price;

import com.challenge.prices_challenge.application.controller.price.response.PriceResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PriceControllerIT {

	private static final String PRICES_URL = "/api/v1/prices";

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	@DisplayName("Test 1. Get price for product 35455, brand 1 and date 2020-06-14T10:00:00")
	void test_1() throws Exception {
		String productId = "35455";
		String brandId = "1";
		String applicationDate = "2020-06-14T10:00:00";

		MockHttpServletResponse response = this.mockMvc.perform(
			MockMvcRequestBuilders
				.get(PRICES_URL)
				.param("productId", productId)
				.param("brandId", brandId)
				.param("applicationDate", applicationDate)
		).andReturn().getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		PriceResponse body = this.objectMapper.readValue(
			response.getContentAsString(),
			new TypeReference<>() {
			}
		);
		assertEquals(
			new PriceResponse(
				35455,
				1,
				1,
				LocalDateTime.of(2020, 6, 14, 0, 0, 0),
				LocalDateTime.of(2020, 12, 31, 23, 59, 59),
				35.5,
				"EUR"
			),
			body
		);
	}

	@Test
	@DisplayName("Test 2. Get price for product 35455, brand 1 and date 2020-06-14T16:00:00")
	void test_2() throws Exception {
		String productId = "35455";
		String brandId = "1";
		String applicationDate = "2020-06-14T16:00:00";

		MockHttpServletResponse response = this.mockMvc.perform(
			MockMvcRequestBuilders
				.get(PRICES_URL)
				.param("productId", productId)
				.param("brandId", brandId)
				.param("applicationDate", applicationDate)
		).andReturn().getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		PriceResponse body = this.objectMapper.readValue(
			response.getContentAsString(),
			new TypeReference<>() {
			}
		);
		assertEquals(
			new PriceResponse(
				35455,
				1,
				2,
				LocalDateTime.of(2020, 6, 14, 15, 0, 0),
				LocalDateTime.of(2020, 6, 14, 18, 30, 0),
				25.45,
				"EUR"
			),
			body
		);
	}

	@Test
	@DisplayName("Test 3. Get price for product 35455, brand 1 and date 2020-06-14T21:00:00")
	void test_3() throws Exception {
		String productId = "35455";
		String brandId = "1";
		String applicationDate = "2020-06-14T21:00:00";

		MockHttpServletResponse response = this.mockMvc.perform(
			MockMvcRequestBuilders
				.get(PRICES_URL)
				.param("productId", productId)
				.param("brandId", brandId)
				.param("applicationDate", applicationDate)
		).andReturn().getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		PriceResponse body = this.objectMapper.readValue(
			response.getContentAsString(),
			new TypeReference<>() {
			}
		);
		assertEquals(
			new PriceResponse(
				35455,
				1,
				1,
				LocalDateTime.of(2020, 6, 14, 0, 0, 0),
				LocalDateTime.of(2020, 12, 31, 23, 59, 59),
				35.5,
				"EUR"
			),
			body
		);
	}

	@Test
	@DisplayName("Test 4. Get price for product 35455, brand 1 and date 2020-06-15T10:00:00")
	void test_4() throws Exception {
		String productId = "35455";
		String brandId = "1";
		String applicationDate = "2020-06-15T10:00:00";

		MockHttpServletResponse response = this.mockMvc.perform(
			MockMvcRequestBuilders
				.get(PRICES_URL)
				.param("productId", productId)
				.param("brandId", brandId)
				.param("applicationDate", applicationDate)
		).andReturn().getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		PriceResponse body = this.objectMapper.readValue(
			response.getContentAsString(),
			new TypeReference<>() {
			}
		);
		assertEquals(
			new PriceResponse(
				35455,
				1,
				3,
				LocalDateTime.of(2020, 6, 15, 0, 0, 0),
				LocalDateTime.of(2020, 6, 15, 11, 0, 0),
				30.5,
				"EUR"
			),
			body
		);
	}

	@Test
	@DisplayName("Test 5. Get price for product 35455, brand 1 and date 2020-06-16T21:00:00")
	void test_5() throws Exception {
		String productId = "35455";
		String brandId = "1";
		String applicationDate = "2020-06-16T21:00:00";

		MockHttpServletResponse response = this.mockMvc.perform(
			MockMvcRequestBuilders
				.get(PRICES_URL)
				.param("productId", productId)
				.param("brandId", brandId)
				.param("applicationDate", applicationDate)
		).andReturn().getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		PriceResponse body = this.objectMapper.readValue(
			response.getContentAsString(),
			new TypeReference<>() {
			}
		);
		assertEquals(
			new PriceResponse(
				35455,
				1,
				4,
				LocalDateTime.of(2020, 6, 15, 16, 0, 0),
				LocalDateTime.of(2020, 12, 31, 23, 59, 59),
				38.95,
				"EUR"
			),
			body
		);
	}

}
