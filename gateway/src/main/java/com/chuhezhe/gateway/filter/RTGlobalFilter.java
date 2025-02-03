package com.chuhezhe.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * ClassName: RTGlobalFilter
 * Package: com.chuhezhe.gateway.filter
 * Description:
 *
 * @Author Chuhezhe
 * @Create 2025/2/3 13:52
 * @Version 1.0
 */

@Slf4j
@Component
public class RTGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        String uri = request.getURI().toString();
        long start = System.currentTimeMillis();
        log.info("请求【{}】开始，时间: {}", uri, start);
        //==========   以上是前置逻辑    ============

        // chain.filter 是全异步的，所以需要在doFinally回调中计算真正的耗时
        Mono<Void> filter = chain.filter(exchange) // Mono是响应式编程里面的去封装一个或零个数据的响应式流
                .doFinally(result -> {
                    // 后置逻辑在这里处理
                    long end = System.currentTimeMillis();
                    log.info("请求【{}】结束，时间: {}, 耗时: {}", uri, end, end - start);
                });

        return filter;
    }


    @Override
    public int getOrder() {
        return 0;
    }
}
