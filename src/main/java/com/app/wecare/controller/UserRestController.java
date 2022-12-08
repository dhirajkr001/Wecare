package com.app.wecare.controller;

import com.app.wecare.dto.request.LoginRequest;
import com.app.wecare.dto.request.UserRequest;
import com.app.wecare.dto.response.ErrorResponse;
import com.app.wecare.dto.response.GenericResponse;
import com.app.wecare.entity.Booking;
import com.app.wecare.entity.User;
import com.app.wecare.exception.WecareException;
import com.app.wecare.mapper.UserMapper;
import com.app.wecare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<GenericResponse> createUser(@Valid @RequestBody UserRequest userRequest, Errors errors) {
        if(errors.hasErrors()){
            String errMsg = errors.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(", "));
            ErrorResponse errorResponse = new ErrorResponse(errMsg);
            errorResponse.setCode(401);
            return ResponseEntity.ok(errorResponse);
        }

        User user = UserMapper.mapUser(userRequest);
        String msg = userService.addCoach(user);
        GenericResponse response = new GenericResponse();
        response.setCode(200);
        response.setMessage(msg);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/login", produces = "application/json")
    ResponseEntity<Boolean> loginUser(@Valid @RequestBody LoginRequest loginRequest) {
        return  ResponseEntity.ok(userService.loginUser(loginRequest));
    }

    @GetMapping(value = "/{userId}", produces = "application/json")
    ResponseEntity<GenericResponse> getUserProfile(@PathVariable Long userId) throws WecareException {
        User user = userService.fetchUserByUserId(userId);
        GenericResponse response = GenericResponse.builder().code(200).data(user).message("Success").build();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/booking/{userId}", produces = "application/json")
    ResponseEntity<GenericResponse> showMyAppointments(@PathVariable Long userId) {
        List<Booking> bookings = userService.fetchAllBookingByUserId(userId);
        String message = null;
        if(bookings.isEmpty()){
            message = "You don't have any appointments!!";
        }
        else{
            message  = "You have " + bookings.size() + " appointments!!";
        }
        return ResponseEntity.ok().body(GenericResponse.builder().code(200).message(message).data(bookings).build());
    }
}
