package com.chuhezhe.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

/**
 * ClassName: DiscoveryTest
 * Package: com.chuhezhe.product
 * Description:
 *
 * @Author Chuhezhe
 * @Create 2025/1/28 23:34
 * @Version 1.0
 */
@SpringBootTest
public class DiscoveryTest {
    @Autowired
    DiscoveryClient discoveryClient;

    @Test
    void discoveryTest() {
        for (String service : discoveryClient.getServices()) {
            System.out.println("service = " + service);

            List<ServiceInstance> instances = discoveryClient.getInstances(service);

            for (ServiceInstance instance : instances) {
                System.out.println("ip: " + instance.getHost() + "; port = " + instance.getPort());
            }
        }
    }
}
