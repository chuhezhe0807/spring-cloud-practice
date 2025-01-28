package com.chuhezhe.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName: com.chuhezhe.order.OrderMainApplication
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author Chuhezhe
 * @Create 2025/1/28 18:27
 * @Version 1.0
 */
@EnableDiscoveryClient // 开启服务发现功能
@SpringBootApplication
public class OrderMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainApplication.class, args);
    }
}
