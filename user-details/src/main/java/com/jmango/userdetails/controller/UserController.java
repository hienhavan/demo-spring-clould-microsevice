package com.jmango.userdetails.controller;

import com.jmango.userdetails.model.Employee;
import com.jmango.userdetails.model.Users;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    String apiKey = "12345";
    List<Users> users = new ArrayList<Users>();
    List<Employee> employees = new ArrayList<Employee>();
    Employee emp1 = new Employee(1L, "John Doe", "abc");
    Users user1 = new Users(1, "a", "a@gmail.com", "01111", "217", (employees));
    Users user2 = new Users(2, "b", "b@gmail.com", "02222", "218", (employees));
    Users user3 = new Users(3, "c", "c@gmail.com", "03333", "219", (employees));

    @GetMapping("/api/v1/get-users")
    public List<Users> getAllUsers(@RequestHeader String key) {
        if (!key.equals(apiKey)) {
            throw new RuntimeException("Invalid API key");
        }
        employees.add(emp1);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        return users;
    }

    @PostMapping("/api/v1/user")
    public Users createUser(@RequestHeader String key,@RequestBody Users user) {
        if (!key.equals(apiKey)) {
            throw new RuntimeException("Invalid API key");
        }
        users.add(user);
        return user;
    }
}
