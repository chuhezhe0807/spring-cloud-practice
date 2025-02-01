package com.chuhezhe.order.exception;

import com.alibaba.csp.sentinel.adapter.spring.webmvc_v6x.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.chuhezhe.common.R;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;

/**
 * ClassName: MyBlockExceptionHandler
 * Package: com.chuhezhe.order.exception
 * Description:
 *
 * @Author Chuhezhe
 * @Create 2025/1/31 19:30
 * @Version 1.0
 */
@Component
public class MyBlockExceptionHandler implements BlockExceptionHandler {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                       String resourceName, BlockException e) throws Exception {
        httpServletResponse.setStatus(429); // to many requests
        httpServletResponse.setContentType("application/json;charset=utf-8");
        R error = R.error(500, resourceName + " 被Sentinel限制了，原因：" + e.getClass());
        String json = objectMapper.writeValueAsString(error);

        PrintWriter writer = httpServletResponse.getWriter();
        writer.write(json);
        writer.flush();
        writer.close();
    }
}
