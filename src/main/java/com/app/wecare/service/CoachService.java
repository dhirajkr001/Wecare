package com.app.wecare.service;

import com.app.wecare.entity.Coach;
import com.app.wecare.exception.WecareException;

public interface CoachService {
    public String addCoach(Coach coach) throws WecareException;
}
