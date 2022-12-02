package com.app.wecare.service;

import com.app.wecare.dto.request.LoginDTO;
import com.app.wecare.entity.Coach;
import com.app.wecare.exception.WecareException;
import com.app.wecare.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoachServiceImpl implements CoachService{

    @Autowired
    private CoachRepository coachRepository;

    @Override
    public String addCoach(Coach coach) {
        coachRepository.save(coach);
        return "Coach Added successfully";
    }

    @Override
    public Boolean loginCoach(LoginDTO loginDTO) {
        Optional<Coach> coach = coachRepository.findById(loginDTO.getId());
        return (coach.isPresent() && coach.get().getPassword().equals(loginDTO.getPassword()));
    }

    @Override
    public Coach fetchCoachByCoachId(Long coachId) throws WecareException {
        Optional<Coach> coach = coachRepository.findById(coachId);
        if(coach.isEmpty()) throw new WecareException("No coach found for the coachId", 4044);
        return coach.get();
    }


}
