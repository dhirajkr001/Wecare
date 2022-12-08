package com.app.wecare.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserRequest {
    private Long userId;
    private String name;
    private String gender;
    private String password;
    private String mobileNumber;
    private String email;
    private LocalDate dob;
    private Address address;
}
