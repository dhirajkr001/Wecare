package com.app.wecare.service;

import com.app.wecare.entity.User;
import com.app.wecare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public String addCoach(User user) {
        userRepository.save(user);
        return "User added successfully";
    }
}
