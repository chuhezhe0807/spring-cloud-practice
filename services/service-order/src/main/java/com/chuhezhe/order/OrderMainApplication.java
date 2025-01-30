package com.chuhezhe.order;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * ClassName: com.chuhezhe.order.OrderMainApplication
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author Chuhezhe
 * @Create 2025/1/28 18:27
 * @Version 1.0
 */
@EnableFeignClients // 开启feign远程调用
@EnableDiscoveryClient // 开启服务发现功能
@SpringBootApplication
public class OrderMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainApplication.class, args);
    }

    // 1、项目启动就监听配置文件的变化
    // 2、发生变化后拿到变化值
    // 3、发送邮件
    @Bean
    ApplicationRunner applicationRunner(NacosConfigManager nacosConfigManager) {
        return args -> {
            ConfigService configService = nacosConfigManager.getConfigService();
            configService.addListener(
                    "service-order.properties",
                    "DEFAULT_GROUP",
                    new Listener() {
                        @Override
                        public Executor getExecutor() {
                            return Executors.newFixedThreadPool(4);
                        }

                        @Override
                        public void receiveConfigInfo(String s) {
                            System.out.println("变化的配置信息：" + s);
                            System.out.println("模拟发送邮件。。。");
                        }
                    }
            );

            System.out.println("ApplicationRunner...");
        };
    }
}
