package com.app.wecare.service;

import com.app.wecare.entity.Coach;
import com.app.wecare.exception.WecareException;
import com.app.wecare.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoachServiceImpl implements CoachService{

    @Autowired
    private CoachRepository coachRepository;

    @Override
    public String addCoach(Coach coach) throws WecareException {
        if ("ppp".equals(coach.getName())) {
            throw new WecareException("Cannot save ppp value", 401);
        }
        coachRepository.save(coach);
        return "Coach Added successfully";
    }
}
