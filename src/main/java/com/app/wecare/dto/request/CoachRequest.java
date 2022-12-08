package com.app.wecare.dto.request;

import com.app.wecare.validation.GenderConstraint;
import com.app.wecare.validation.MobileNumberConstraint;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class CoachRequest {

    @NotBlank
    private String name;
    @GenderConstraint
    private String gender;
    @Temporal(TemporalType.DATE)
    private LocalDate dob;
    @Size(min = 6, message = "Password size must be greater than 6 characters")
    private String password;
    @MobileNumberConstraint
    private Long mobileNumber;
    @NotBlank
    private String speciality;
}
