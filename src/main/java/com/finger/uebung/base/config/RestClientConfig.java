package com.finger.uebung.base.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class RestClientConfig {

    @Bean
    public ObjectMapper objectMapper(){

        return new ObjectMapper();
    }

    @Bean
    public WebClient.Builder webClientBuilder() {

        return WebClient.builder();
    }

    @Bean
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){

        return new MappingJackson2HttpMessageConverter();
    }
}