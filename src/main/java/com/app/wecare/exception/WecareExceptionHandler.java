package com.app.wecare.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class WecareExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleError(MethodArgumentNotValidException err){
        ErrorMessage error = new ErrorMessage();
        error.setCode(200);
        error.setMessage(err.getBindingResult().getAllErrors().stream()
                .map(ObjectError::getDefaultMessage).collect(Collectors.joining(", ")));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WecareException.class )
    public ResponseEntity<ErrorMessage> handleWeCareException(WecareException err){
        return new ResponseEntity<>(err.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ServletRequestBindingException.class)
    public ResponseEntity<ErrorMessage> handleServletRequestBindingException(ServletRequestBindingException err){
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage(err.getMessage());
        errorMessage.setCode(400);
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
