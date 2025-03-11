package com.example.OpenFeign.apis.impl;

import com.example.OpenFeign.apis.IStaticService;
import com.example.OpenFeign.apis.model.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
/** khi bị lỗi feign proxy sẽ tự động gọi vi da duoc khai bao trong @FeignClient và class nay trien khai interface nay */
public class StaticService implements IStaticService {
    @Override
    public List<UserResponse> getUser(String key) {
        log.error("Static service is slow");
        return null;
    }

    @Override
    public UserResponse saveUser(String key, UserResponse user) {
        log.error("Static service is slow");
        return null;
    }

}
