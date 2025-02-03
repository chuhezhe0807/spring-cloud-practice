package com.chuhezhe.order.feign;

import com.chuhezhe.order.feign.fallback.ProductFeignClientFallback;
import com.chuhezhe.product.bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: ProductFeignClient
 * Package: com.chuhezhe.order.feign
 * Description:
 *
 * @Author Chuhezhe
 * @Create 2025/1/30 14:53
 * @Version 1.0
 */
@FeignClient(value = "service-product", fallback = ProductFeignClientFallback.class) // 指定远程调用哪个微服务，指定失败后的兜底回调
public interface ProductFeignClient {

    // 方法返回值 Product 指的是将远程调用请求到的数据封装成Product
    // MVC注解有两套逻辑
    // 1、写在controller中，是指接受这样的请求，参数就是接受参数
    // 2、写在feignClient上，是指发送这样的请求，参数是将这个参数放到请求中
    @GetMapping("/product/{id}")
    Product getProductById(@PathVariable("id") Long id);
    // 如果需要向请求头中写入token，可以这样写
//    void getProductById(@PathVariable("id") Long id, @RequestHeader("token") String token);
}
