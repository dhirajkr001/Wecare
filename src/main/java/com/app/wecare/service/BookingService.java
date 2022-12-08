package com.app.wecare.service;

import com.app.wecare.dto.request.BookingRequest;
import com.app.wecare.dto.request.BookingRescheduleRequest;
import com.app.wecare.exception.WecareException;
import org.springframework.dao.EmptyResultDataAccessException;

public interface BookingService {
    void bookAppointment(BookingRequest bookingRequest) throws WecareException;

    void rescheduleAppointment(BookingRescheduleRequest bookingRescheduleRequest, Long bookingId) throws WecareException;

    void deleteAppointment(Long bookingId) throws EmptyResultDataAccessException;
}
