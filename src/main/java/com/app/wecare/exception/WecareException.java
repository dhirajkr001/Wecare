package com.app.wecare.exception;

import lombok.Getter;

@Getter
public class WecareException extends Exception{

    private ErrorMessage errorMessage;

    public WecareException(String message, Integer code){
        this.errorMessage.setMessage(message);
        this.errorMessage.setCode(code);
    }
}
