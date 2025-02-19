package com.example.OpenFeign.apis.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponse {
    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
}
