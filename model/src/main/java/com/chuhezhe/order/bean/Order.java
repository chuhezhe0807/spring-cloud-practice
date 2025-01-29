package com.chuhezhe.order.bean;

import com.chuhezhe.product.bean.Product;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * ClassName: Order
 * Package: com.chuhezhe.order.bean
 * Description:
 *
 * @Author Chuhezhe
 * @Create 2025/1/29 12:35
 * @Version 1.0
 */
@Data
public class Order {
    private Long id;
    private BigDecimal totalAmount;
    private Long userId;
    private String nickName;
    private String address;
    private List<Product> productList;
}
