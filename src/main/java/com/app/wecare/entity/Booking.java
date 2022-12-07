package com.app.wecare.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Booking {
    @Id
    @TableGenerator(name = "booking_id_gen", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(generator = "booking_id_gen")
    private Long bookingId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "coach_id")
    private Long coachId;
    @Column
    private LocalDate bookingDate;
    @Column
    private LocalTime startTime;
    @Column
    private LocalTime endTime;
}
