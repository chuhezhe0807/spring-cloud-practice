package com.chuhezhe.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

/**
 * ClassName: LoadBalancerTest
 * Package: com.chuhezhe.order
 * Description:
 *
 * @Author Chuhezhe
 * @Create 2025/1/29 16:14
 * @Version 1.0
 */
@SpringBootTest
public class LoadBalancerTest {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Test
    void testLoadBalancerClient() {
        // 负载均衡的取出一个可用的服务
        ServiceInstance choose = loadBalancerClient.choose("service-product");
        System.out.println("choose = " + choose.getHost() + ":" + choose.getPort());
        choose = loadBalancerClient.choose("service-product");
        System.out.println("choose = " + choose.getHost() + ":" + choose.getPort());
        choose = loadBalancerClient.choose("service-product");
        System.out.println("choose = " + choose.getHost() + ":" + choose.getPort());
        choose = loadBalancerClient.choose("service-product");
        System.out.println("choose = " + choose.getHost() + ":" + choose.getPort());
        choose = loadBalancerClient.choose("service-product");
        System.out.println("choose = " + choose.getHost() + ":" + choose.getPort());
    }
}
