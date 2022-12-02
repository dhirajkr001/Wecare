package com.app.wecare.service;

import com.app.wecare.dto.request.LoginDTO;
import com.app.wecare.entity.Coach;
import com.app.wecare.exception.WecareException;

import java.util.List;

public interface CoachService {
     String addCoach(Coach coach);

     Boolean loginCoach(LoginDTO loginDTO);

     Coach fetchCoachByCoachId(Long coachId) throws WecareException;

     List<Coach> fetchAllCoach();
}
