package com.app.wecare.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private Long id;
    private String password;
}
