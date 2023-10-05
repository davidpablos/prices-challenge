package com.challenge.prices_challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
	"com.challenge.prices_challenge.application.bean",
	"com.challenge.prices_challenge.application.controller",
	"com.challenge.prices_challenge.application.exception_handler"
})
public class PricesChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PricesChallengeApplication.class, args);
	}

}
