package com.app.wecare.service;

import com.app.wecare.dto.request.BookingDTO;
import com.app.wecare.exception.WecareException;

public interface BookingService {
    void bookAppointment(BookingDTO bookingDTO) throws WecareException;
}
