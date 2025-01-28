package com.chuhezhe.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName: ProductMainApplication
 * Package: com.chuhezhe
 * Description:
 *
 * @Author Chuhezhe
 * @Create 2025/1/28 23:13
 * @Version 1.0
 */
@EnableDiscoveryClient // 开启服务发现功能
@SpringBootApplication
public class ProductMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductMainApplication.class, args);
    }
}
