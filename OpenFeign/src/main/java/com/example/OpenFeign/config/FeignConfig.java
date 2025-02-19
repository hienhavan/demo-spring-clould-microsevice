package com.example.OpenFeign.config;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FeignConfig {
    /**    Giới hạn thời gian chờ kết nối với server.
     read-timeout: Giới hạn thời gian chờ phản hồi từ server. */
    @Bean
    public Request.Options feignOptions() {
        return new Request.Options(5000, 5000);
    }
}
