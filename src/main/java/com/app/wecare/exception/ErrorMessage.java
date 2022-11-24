package com.app.wecare.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage {
    private String message;
    private Integer code;
}
