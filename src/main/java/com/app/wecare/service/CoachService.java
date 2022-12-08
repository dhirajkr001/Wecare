package com.app.wecare.service;

import com.app.wecare.dto.request.LoginRequest;
import com.app.wecare.entity.Coach;
import com.app.wecare.exception.WecareException;

import java.util.List;

public interface CoachService {
     String addCoach(Coach coach);

     Boolean loginCoach(LoginRequest loginRequest);

     Coach fetchCoachByCoachId(Long coachId) throws WecareException;

     List<Coach> fetchAllCoach();
}
