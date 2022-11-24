package com.app.wecare.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class User {
    private String userId;
    private String name;
    private String gender;
    private String password;
    private String mobileNumber;
    private String email;
    private LocalDate dob;
    private Address address;
}
