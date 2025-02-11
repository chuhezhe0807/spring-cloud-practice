package com.chuhezhe.product.controller;

import com.chuhezhe.product.bean.Product;
import com.chuhezhe.product.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long productId, HttpServletRequest request) {
        String header = request.getHeader("X-Token");
        System.out.println("hello + token = " + header); // 控制台查看通过注解的方式实现的请求负载均衡，是否成功
        Product product = productService.getProductById(productId);

        return product;
    }
}
