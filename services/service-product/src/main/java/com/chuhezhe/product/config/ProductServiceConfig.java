package com.chuhezhe.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: ProductServiceConfig
 * Package: com.chuhezhe.product.config
 * Description:
 *
 * @Author Chuhezhe
 * @Create 2025/1/29 14:20
 * @Version 1.0
 */
@Configuration
public class ProductServiceConfig {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
