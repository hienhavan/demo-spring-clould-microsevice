package com.example.OpenFeign.controller;

import com.example.OpenFeign.apis.IStaticService;
import com.example.OpenFeign.apis.model.EmployeeResponse;
import com.example.OpenFeign.apis.model.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class OpenFeign {
    private String apiKey = "12345";
    private final IStaticService service;
    List<EmployeeResponse> employees = new ArrayList<>();
    EmployeeResponse emp1 = new EmployeeResponse(1L, "John Doe", "abc");
    UserResponse user1 = new UserResponse(4, "d", "d@gmail.com", "04444", "217", (employees));

    @GetMapping("/api/v1/users")
    public List<UserResponse> getUserById() {
        return service.getUser(apiKey);
    }

    @PostMapping("/api/v1/user")
    public UserResponse createUser() {
        employees.add(emp1);
        return service.saveUser(apiKey, user1);
    }
}
