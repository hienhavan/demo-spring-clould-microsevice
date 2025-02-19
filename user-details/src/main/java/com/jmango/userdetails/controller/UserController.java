package com.jmango.userdetails.controller;

import com.jmango.userdetails.model.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    List<Users> users = new ArrayList<Users>();
    Users user1 = new Users(1, "a", "a@gmail.com", "01111", "217");
    Users user2 = new Users(2, "b", "b@gmail.com", "02222", "218");
    Users user3 = new Users(3, "c", "c@gmail.com", "03333", "219");

    @GetMapping("/api/v1/get-users")
    public List<Users> getAllUsers() {
        users.add(user1);
        users.add(user2);
        users.add(user3);
        return users;
    }
}
