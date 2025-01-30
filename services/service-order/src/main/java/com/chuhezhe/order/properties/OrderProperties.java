package com.chuhezhe.order.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ClassName: OrderProperties
 * Package: com.chuhezhe.order.properties
 * Description:
 *
 * @Author Chuhezhe
 * @Create 2025/1/29 21:55
 * @Version 1.0
 */
@Component
@ConfigurationProperties(prefix = "order") // 配置批量绑定在nacos下，可以无需@RefreshScope就能实现自动刷新
@Data
public class OrderProperties {
    String timeout;

    String autoConfirm;

    String dbUrl;
}
