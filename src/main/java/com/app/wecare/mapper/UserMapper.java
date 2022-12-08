package com.app.wecare.mapper;

import com.app.wecare.dto.request.UserRequest;
import com.app.wecare.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public static User mapUser(UserRequest userRequest) {
        User user = new User();
        user.setUserId(userRequest.getUserId());
        user.setDob(userRequest.getDob());
        user.setGender(userRequest.getGender());
        user.setName(userRequest.getName());
        user.setPassword(userRequest.getPassword());
        user.setAddress(userRequest.getAddress());
        user.setMobileNumber(userRequest.getMobileNumber());
        user.setEmail(userRequest.getEmail());
        return user;

    }
}
