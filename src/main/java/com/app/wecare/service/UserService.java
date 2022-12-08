package com.app.wecare.service;

import com.app.wecare.dto.request.LoginRequest;
import com.app.wecare.entity.Booking;
import com.app.wecare.entity.User;
import com.app.wecare.exception.WecareException;

import java.util.List;

public interface UserService {

    String addCoach(User user);

    Boolean loginUser(LoginRequest loginRequest);

    User fetchUserByUserId(Long userId) throws WecareException;

    List<Booking>  fetchAllBookingByUserId(Long userId);

}
