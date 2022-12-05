package com.app.wecare.mapper;

import com.app.wecare.dto.request.UserDTO;
import com.app.wecare.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public static User mapUser(UserDTO userDTO) {
        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setDob(userDTO.getDob());
        user.setGender(userDTO.getGender());
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setAddress(userDTO.getAddress());
        user.setMobileNumber(userDTO.getMobileNumber());
        user.setEmail(userDTO.getEmail());
        return user;

    }
}
