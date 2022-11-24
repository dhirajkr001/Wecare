package com.app.wecare.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private Integer pinCode;
    private String city;
    private String state;
    private String country;
}
