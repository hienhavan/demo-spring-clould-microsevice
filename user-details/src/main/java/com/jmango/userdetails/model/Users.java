package com.jmango.userdetails.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
}
