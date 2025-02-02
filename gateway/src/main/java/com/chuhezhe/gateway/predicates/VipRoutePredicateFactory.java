package com.chuhezhe.gateway.predicates;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * ClassName: VipRoutePredicateFactory
 * Package: com.chuhezhe.gateway.predicates
 * Description:
 *
 * @Author Chuhezhe
 * @Create 2025/2/2 22:23
 * @Version 1.0
 */
@Component  // 需要将自定义的路由断言组件加入到容器中
public class VipRoutePredicateFactory extends AbstractRoutePredicateFactory<VipRoutePredicateFactory.Config> {

    public VipRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(VipRoutePredicateFactory.Config config) {
        return new GatewayPredicate() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                // localhost/search?q=haha&user=xiaozhang 满足这个请求格式的才可以跳转路由
                ServerHttpRequest request = serverWebExchange.getRequest();
                String first = request.getQueryParams().getFirst(config.param);

                // 获取param对应的参数是否是config.value
                return StringUtils.hasText(first) && first.equals(config.value);
            }
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("param", "value"); // 指定在配置路由规则时参数的对应关系，即 "user,xiaozhang" user对应param xiaozhang对应value
    }

    // 可以配置的参数
    @Validated
    public static class Config {

        @NotEmpty
        private String param;

        @NotEmpty
        private String value;

        public String getParam() {
            return param;
        }

        public void setParam(String param) {
            this.param = param;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
