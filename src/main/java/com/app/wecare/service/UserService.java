package com.app.wecare.service;

import com.app.wecare.dto.request.LoginDTO;
import com.app.wecare.entity.User;
import com.app.wecare.exception.WecareException;

public interface UserService {

    String addCoach(User user);

    Boolean loginUser(LoginDTO loginDTO);

    User fetchUserByUserId(Long userId) throws WecareException;

}