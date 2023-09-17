package com.unsa.reniec.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean("reniec-rest-template")
    public RestTemplate setRestTemplate() {
        return new RestTemplate();
    }

}
