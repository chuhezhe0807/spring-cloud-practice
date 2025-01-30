package com.chuhezhe.order;

import com.chuhezhe.order.feign.WeatherFeignClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ClassName: WeatherFeignClientTest
 * Package: com.chuhezhe.order
 * Description:
 *
 * @Author Chuhezhe
 * @Create 2025/1/30 15:48
 * @Version 1.0
 */
@SpringBootTest
public class WeatherFeignClientTest {

    @Autowired
    WeatherFeignClient weatherFeignClient;

    @Test
    void test01() {
        String weather = weatherFeignClient.getWeather(
                "APPCODE 93b7e19861a24c519a7548b17dc16d75",
                "50b53ff8dd7d9fa320d3d3ca32cf8ed1",
                "2182");

        System.out.println(weather);
    }
}
