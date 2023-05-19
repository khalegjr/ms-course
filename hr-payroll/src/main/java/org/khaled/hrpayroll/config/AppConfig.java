package org.khaled.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

@Configuration
@CrossOrigin(origins = "localhost:8101", maxAge = 3600)
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    };
}
