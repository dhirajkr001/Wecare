package com.app.wecare.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Coach {
    @Id
    @Column(name = "coach_id")
    @TableGenerator(name = "coach_id_generator", initialValue = 100000, allocationSize = 1)
    @GeneratedValue(generator = "coach_id_generator")
    private Long coachId;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "dob")
    private LocalDate dob;
    @Column
    @JsonIgnore
    private String password;
    @Column(name = "mobile_no")
    private Long mobileNumber;
    @Column(name = "speciality")
    private String speciality;
}
