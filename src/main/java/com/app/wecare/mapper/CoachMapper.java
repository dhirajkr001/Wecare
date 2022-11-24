package com.app.wecare.mapper;

import com.app.wecare.dto.CoachDTO;
import com.app.wecare.entity.Coach;
import org.springframework.stereotype.Component;

@Component
public class CoachMapper {
    public static Coach mapCoach(CoachDTO coachDTO) {
        Coach coach = new Coach();
        coach.setDob(coachDTO.getDob());
        coach.setGender(coachDTO.getGender());
        coach.setName(coachDTO.getName());
        coach.setPassword(coachDTO.getPassword());
        coach.setSpeciality(coachDTO.getSpeciality());
        coach.setMobileNumber(coachDTO.getMobileNumber());
        return coach;
    }
}
