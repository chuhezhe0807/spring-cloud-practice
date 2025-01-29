package com.chuhezhe.product.controller;

import com.chuhezhe.product.bean.Product;
import com.chuhezhe.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: ProductController
 * Package: com.chuhezhe.product.controller
 * Description:
 *
 * @Author Chuhezhe
 * @Create 2025/1/29 11:43
 * @Version 1.0
 */
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    // 查询商品
    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable("id") Long productId) {
        Product product = productService.getProductById(productId);

        return product;
    }
}
