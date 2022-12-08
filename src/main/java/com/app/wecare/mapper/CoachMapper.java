package com.app.wecare.mapper;

import com.app.wecare.dto.request.CoachRequest;
import com.app.wecare.entity.Coach;
import org.springframework.stereotype.Component;

@Component
public class CoachMapper {
    public static Coach mapCoach(CoachRequest coachRequest) {
        Coach coach = new Coach();
        coach.setDob(coachRequest.getDob());
        coach.setGender(coachRequest.getGender());
        coach.setName(coachRequest.getName());
        coach.setPassword(coachRequest.getPassword());
        coach.setSpeciality(coachRequest.getSpeciality());
        coach.setMobileNumber(coachRequest.getMobileNumber());
        return coach;
    }
}
