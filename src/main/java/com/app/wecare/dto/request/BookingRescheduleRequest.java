package com.app.wecare.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class BookingRescheduleRequest {
    @NotNull
    LocalTime startTime;
    @NotNull
    LocalTime endTime;
    @NotNull
    LocalDate bookingDate;
}
