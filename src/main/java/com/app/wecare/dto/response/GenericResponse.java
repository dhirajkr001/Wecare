package com.app.wecare.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse {
    private Integer code;
    private String message;
    private UUID correlationId;
    Object data;
}
