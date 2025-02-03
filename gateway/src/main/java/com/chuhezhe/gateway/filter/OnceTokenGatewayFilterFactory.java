package com.chuhezhe.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * ClassName: OnceTokenGatewayFilterFactory
 * Package: com.chuhezhe.gateway.filter
 * Description: 添加一次性的token过滤器
 *
 * @Author Chuhezhe
 * @Create 2025/2/3 14:08
 * @Version 1.0
 */
@Component
public class OnceTokenGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {

    @Override
    public GatewayFilter apply(NameValueConfig config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                return chain
                        .filter(exchange)
                        .then(Mono.fromRunnable(() -> {
                            ServerHttpResponse response = exchange.getResponse();
                            HttpHeaders headers = response.getHeaders();
                            String value = config.getValue();

                            if("uuid".equals(value)) {
                                value = UUID.randomUUID().toString();
                            }
                            else if("jwt".equals(value)) {
                                value = "mock_token_str";
                            }

                            headers.add(config.getName(), value);
                        }));
            }
        };
    }
}
