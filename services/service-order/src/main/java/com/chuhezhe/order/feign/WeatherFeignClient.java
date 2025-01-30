package com.chuhezhe.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName: WeatherFeignClient
 * Package: com.chuhezhe.order.feign
 * Description:
 *
 * @Author Chuhezhe
 * @Create 2025/1/30 15:43
 * @Version 1.0
 */
@FeignClient(value = "weather-client", url = "http://aliv18.data.moji.com")
public interface WeatherFeignClient {

    @PostMapping("/whapi/json/alicityweather/condition")
    String getWeather(
            @RequestHeader("Authorization") String auth,
            @RequestParam("token") String token,
            @RequestParam("cityId") String cityId
    );
}
