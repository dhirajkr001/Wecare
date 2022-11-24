package com.app.wecare.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class Booking {
    private UUID bookingId;
    private String userId;
    private String coachId;
    private LocalDate bookingDate;
    private String slot;
}
