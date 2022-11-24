package com.app.wecare.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse extends GenericResponse{
    private String errorMessage;
}
