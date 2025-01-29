package com.chuhezhe.product.service;

import com.chuhezhe.product.bean.Product;

/**
 * ClassName: ProductService
 * Package: com.chuhezhe.product.service
 * Description:
 *
 * @Author Chuhezhe
 * @Create 2025/1/29 12:18
 * @Version 1.0
 */
public interface ProductService {
    Product getProductById(Long id);
}
