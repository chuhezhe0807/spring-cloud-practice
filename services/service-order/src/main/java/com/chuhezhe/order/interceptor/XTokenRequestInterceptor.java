package com.chuhezhe.order.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * ClassName: XTokenRequestInterceptor
 * Package: com.chuhezhe.order.interceptor
 * Description:
 *
 * @Author Chuhezhe
 * @Create 2025/1/30 19:59
 * @Version 1.0
 */
@Component // 只要容器中有这个组件，open feign就会在每一次请求的时候调用
public class XTokenRequestInterceptor implements RequestInterceptor {

    // 请求拦截器
    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println("XTokenRequestInterceptor...");
        requestTemplate.header("X-Token", UUID.randomUUID().toString());
    }
}
