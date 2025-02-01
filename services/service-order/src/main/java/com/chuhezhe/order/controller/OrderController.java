package com.chuhezhe.order.controller;

import com.chuhezhe.order.bean.Order;
import com.chuhezhe.order.properties.OrderProperties;
import com.chuhezhe.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderProperties orderProperties;

    // 获取发布的配置
    @GetMapping("/config")
    public String config() {
        return "order.timeout=" + orderProperties.getTimeout() +
                "; order.auto-confirm=" + orderProperties.getAutoConfirm() +
                "; order.db-url=" + orderProperties.getDbUrl();
    }

    // 创建订单
    @GetMapping("/create")
    public Order createOrder(@RequestParam("userId") Long userId,
                             @RequestParam("productId") Long productId) {
        Order order = orderService.createOrder(productId, userId);

        return order;
    }

    // 秒杀订单
    // 测试流控规则中的高级设置中的流控模式-链路，普通创建订单不限制，秒杀创建订单限制
    // 流控模式-链路指的是从哪一条路来到这个簇点链路节点的，只有指定的路进来的才会被限制
    @GetMapping("/seckill")
    public Order seckill(@RequestParam("userId") Long userId,
                             @RequestParam("productId") Long productId) {
        Order order = orderService.createOrder(productId, userId);
        order.setId(Long.MAX_VALUE);

        return order;
    }

    // 关联流控模式，对/readDB设置关联流控模式，关联/writeDB，如果/writeDB访问量极大时，这时在访问/readDB则会被限制
    // 关联流控模式单独访问设置流控模式的资源不会被限制，只有访问关联资源访问量大时，再访问设置模式的资源才会被限制
    // 应用场景为数据库在进行大量的写操作时，对读操作作出限制
    @GetMapping("/readDB")
    public String readDB() {
        log.info("readDB...");
        return "readDB success....";
    }

    @GetMapping("/writeDB")
    public String writeDB() {
        log.info("writeDB...");
        return "writeDB success....";
    }
}
