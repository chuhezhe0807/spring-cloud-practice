package com.chuhezhe.product.service.impl;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import com.chuhezhe.product.bean.Product;
import com.chuhezhe.product.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * ClassName: ProductServiceImpl
 * Package: com.chuhezhe.product.service.impl
 * Description:
 *
 * @Author Chuhezhe
 * @Create 2025/1/29 12:18
 * @Version 1.0
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product getProductById(Long id) {
        Product product = new Product();
        product.setId(id);
        product.setPrice(new BigDecimal("99"));
        product.setProductName("苹果-" + id);
        product.setNum(2);

//        try {
//            TimeUnit.SECONDS.sleep(100);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        return product;
    }
}
