package com.chuhezhe.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: OrderServiceConfig
 * Package: com.chuhezhe.order.config
 * Description:
 *
 * @Author Chuhezhe
 * @Create 2025/1/29 14:36
 * @Version 1.0
 */
@Configuration
public class OrderServiceConfig {

    @LoadBalanced // 基于注解的负载均衡
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
