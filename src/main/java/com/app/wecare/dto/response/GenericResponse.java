package com.app.wecare.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class GenericResponse {
    private Integer code;
    private String message;
    private UUID correlationId;
}
