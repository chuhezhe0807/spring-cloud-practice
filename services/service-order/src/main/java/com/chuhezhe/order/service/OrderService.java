package com.chuhezhe.order.service;

import com.chuhezhe.order.bean.Order;

/**
 * ClassName: OrderService
 * Package: com.chuhezhe.order.service
 * Description:
 *
 * @Author Chuhezhe
 * @Create 2025/1/29 12:36
 * @Version 1.0
 */
public interface OrderService {
    Order createOrder(Long productId, Long userId);
}
