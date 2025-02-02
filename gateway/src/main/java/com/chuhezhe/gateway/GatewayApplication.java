package com.chuhezhe.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName: GatewayApplication
 * Package: com.chuhezhe.gateway
 * Description:
 *
 * @Author Chuhezhe
 * @Create 2025/2/2 15:43
 * @Version 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
