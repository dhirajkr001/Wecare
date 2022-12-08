package com.app.wecare.service;

import com.app.wecare.dto.request.LoginRequest;
import com.app.wecare.entity.User;
import com.app.wecare.exception.WecareException;
import com.app.wecare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public String addCoach(User user) {
        userRepository.save(user);
        return "User added successfully";
    }

    @Override
    public Boolean loginUser(LoginRequest loginRequest) {
        Optional<User> user = userRepository.findById(loginRequest.getId());
        return user.isPresent() && user.get().getPassword().equals(loginRequest.getPassword());
    }

    @Override
    public User fetchUserByUserId(Long userId) throws WecareException {
       Optional<User> user =  userRepository.findById(userId);
        if(user.isEmpty()) throw new WecareException("No user found for the coachId", 4044);
        return user.get();
    }
}
