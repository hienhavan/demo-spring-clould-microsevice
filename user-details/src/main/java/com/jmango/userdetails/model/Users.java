package com.jmango.userdetails.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    @Setter(AccessLevel.NONE)
    private List<Employee> employees = new ArrayList<>();

    public void setEmployees(List<Employee> employees) {
        this.employees = (employees == null) ? new ArrayList<>() : new ArrayList<>(employees);

    }

    public List<Employee> getEmployees() {
        return (employees == null) ? new ArrayList<>() : new ArrayList<>(employees);
    }

}
