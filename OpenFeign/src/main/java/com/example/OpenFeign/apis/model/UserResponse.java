package com.example.OpenFeign.apis.model;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    @Setter(AccessLevel.NONE)
    private List<EmployeeResponse> employees;

    }

