package com.app.wecare.controller;

import com.app.wecare.dto.request.UserDTO;
import com.app.wecare.dto.response.ErrorResponse;
import com.app.wecare.dto.response.GenericResponse;
import com.app.wecare.entity.User;
import com.app.wecare.mapper.UserMapper;
import com.app.wecare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("users")
public class UserRestController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<GenericResponse> createUser(@Valid @RequestBody UserDTO userDTO, Errors errors) {
        if(errors.hasErrors()){
            String errMsg = errors.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(", "));
            ErrorResponse errorResponse = new ErrorResponse(errMsg);
            errorResponse.setCode(401);
            return ResponseEntity.ok(errorResponse);
        }

        User user = UserMapper.mapUser(userDTO);
        String msg = userService.addCoach(user);
        GenericResponse response = new GenericResponse();
        response.setCode(200);
        response.setMessage(msg);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
