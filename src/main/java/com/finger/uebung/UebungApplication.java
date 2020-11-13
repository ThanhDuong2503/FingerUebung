package com.finger.uebung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class UebungApplication {

	@Bean
	public WebClient webClient() {

		return WebClient.create();
	}

	public static void main(String[] args) {
		SpringApplication.run(UebungApplication.class, args);
	}

}
