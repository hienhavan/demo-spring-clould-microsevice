package com.example.OpenFeign.apis;

import com.example.OpenFeign.apis.model.UserResponse;
import com.example.OpenFeign.apis.impl.StaticService;
import com.example.OpenFeign.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "user-details", configuration = FeignConfig.class, fallback = StaticService.class)
/** (name) trung voi name trong spring.application.name tai moi service (configuration nay de cau hinh cau hinh thu cong, neu khong co thi se su dung cau hinh mac dinh)
 * @GetMaping la endpoint can goi
 * fallback voi resilience4j khi co ex nhay vao ham fallback
 * do dung eureka nen khong can Hardcode @FeignClient neu khong no eureka thi phai co url de feign biet goi den duong dan nao (url = http://localhost:8086)*/
public interface IStaticService {
    @GetMapping("/api/v1/get-users")
    List<UserResponse> getUser(@RequestHeader String key);

    @PostMapping("/api/v1/user")
    UserResponse saveUser(@RequestHeader String key, @RequestBody UserResponse user);
}
