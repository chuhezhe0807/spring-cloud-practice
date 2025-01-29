package com.chuhezhe.order.service.impl;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.chuhezhe.order.bean.Order;
import com.chuhezhe.order.service.OrderService;
import com.chuhezhe.product.bean.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: ServiceImpl
 * Package: com.chuhezhe.order.service.impl
 * Description:
 *
 * @Author Chuhezhe
 * @Create 2025/1/29 12:37
 * @Version 1.0
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Order createOrder(Long productId, Long userId) {
        Product product = getProductFromRemote(productId);
        Order order = new Order();
        order.setId(1L);
        // 总金额
        order.setTotalAmount(product.getPrice().multiply(new BigDecimal(product.getNum())));
        order.setUserId(userId);
        order.setNickName("张三");
        order.setAddress("chengdu");
        order.setProductList(Arrays.asList(product));

        return order;
    }

    // 从远程获取Product
    private Product getProductFromRemote(Long productId) {
        // 1、获取到商品服务所在的机器IP+port
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");

        ServiceInstance instance = instances.get(0);
        // 远程URL http://localhost:9003/product/7
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/product/" + productId;

        log.info("远程请求: {}", url);
        // 2、给远程发送请求
        Product product = restTemplate.getForObject(url, Product.class);

        return product;
    }
}
