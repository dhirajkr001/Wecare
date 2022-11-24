package com.app.wecare.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    private Integer pinCode;
    private String city;
    private String state;
    private String country;
}
