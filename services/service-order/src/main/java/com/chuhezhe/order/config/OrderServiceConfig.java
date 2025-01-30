package com.chuhezhe.order.config;

import feign.Logger;
import feign.Retryer;
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

    // 设置 feign 日志的level
    @Bean
    Logger.Level getLoggerLevel() {
        return Logger.Level.FULL;
    }

    // 设置重试机制
    @Bean
    Retryer getRetryer() {
        return new Retryer.Default(); // 采用默认重试机制 最大重试次数5次（第一次包含在内），每间隔100ms重试，每次需要乘1.5的系数，最大时间为1s
    }
}
