package com.chuhezhe.product.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * ClassName: Product
 * Package: com.chuhezhe.product.bean
 * Description:
 *
 * @Author Chuhezhe
 * @Create 2025/1/29 12:15
 * @Version 1.0
 */
@Data
public class Product {
    private Long id;
    private BigDecimal price;
    private String productName;
    private int num;
}
