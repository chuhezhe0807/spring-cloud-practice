package com.chuhezhe.order.feign.fallback;
import java.math.BigDecimal;

import com.chuhezhe.order.feign.ProductFeignClient;
import com.chuhezhe.product.bean.Product;
import org.springframework.stereotype.Component;

/**
 * ClassName: ProductFeignClientFallback
 * Package: com.chuhezhe.order.feign.fallback
 * Description: ProductFeignClient 兜底回调，远程调用失败了才会调用兜底的逻辑
 *
 * @Author Chuhezhe
 * @Create 2025/1/30 21:19
 * @Version 1.0
 */
@Component
public class ProductFeignClientFallback implements ProductFeignClient {
    @Override
    public Product getProductById(Long id) {
        System.out.println("兜底回调。。。。");
        Product product = new Product();
        product.setId(id);
        product.setPrice(new BigDecimal("0"));
        product.setProductName("未知商品...");
        product.setNum(0);

        return product;
    }
}
