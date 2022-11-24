package com.app.wecare.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Coach {
    @Id
    @Column(name = "coach_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long coachId;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "dob")
    private LocalDate dob;
    @Column
    private String password;
    @Column(name = "mobile_no")
    private Integer mobileNumber;
    @Column(name = "speciality")
    private String speciality;
}
