package com.app.wecare.exception;

import lombok.Getter;

@Getter
public class WecareException extends Exception{

    private ErrorMessage errorMessage;

    public WecareException(String message, Integer code){
        ErrorMessage errorMessage1 = new ErrorMessage();
        errorMessage1.setMessage(message);
        errorMessage1.setCode(code);
        this.errorMessage = errorMessage1;
    }
}
