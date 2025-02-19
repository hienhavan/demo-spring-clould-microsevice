package com.example.OpenFeign.controller;

import com.example.OpenFeign.apis.IStaticService;
import com.example.OpenFeign.apis.model.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OpenFeign {
    private final IStaticService service;

    @GetMapping("/api/v1/get-user")
    public List<UserResponse> getUserById() {
        return service.getUser();
    }
}
