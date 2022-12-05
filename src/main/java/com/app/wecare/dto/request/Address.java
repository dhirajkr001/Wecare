package com.app.wecare.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @NotEmpty
    private Integer pinCode;
    @NotEmpty
    private String city;
    @NotEmpty
    private String state;
    @NotEmpty
    private String country;
}
