package com.chuhezhe.order.controller;

import com.chuhezhe.order.bean.Order;
import com.chuhezhe.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: OrderController
 * Package: com.chuhezhe.order.controller
 * Description:
 *
 * @Author Chuhezhe
 * @Create 2025/1/29 12:34
 * @Version 1.0
 */
@RefreshScope // 当配置修改时，自动刷新 orderTimeout orderAutoConfirm 两个值
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Value("${order.timeout}")
    String orderTimeout;

    @Value("${order.auto-confirm}")
    String orderAutoConfirm;

    // 获取发布的配置
    @GetMapping("/config")
    public String config() {
        return "order.timeout=" + orderTimeout + "; order.auto-confirm=" + orderAutoConfirm;
    }

    // 创建订单
    @GetMapping("/create")
    public Order createOrder(@RequestParam("userId") Long userId,
                             @RequestParam("productId") Long productId) {
        Order order = orderService.createOrder(productId, userId);

        return order;
    }
}
