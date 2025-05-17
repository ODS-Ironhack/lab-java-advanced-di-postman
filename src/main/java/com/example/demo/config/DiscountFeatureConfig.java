package com.example.demo.config;

import com.example.demo.services.EarlyBirdDiscountService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class DiscountFeatureConfig {

    @Bean
    @ConditionalOnProperty(name="feature.earlybird.enabled", havingValue = "true", matchIfMissing = false)
    public EarlyBirdDiscountService earlyBirdDiscountService(){
        return new EarlyBirdDiscountService();
    }
}
