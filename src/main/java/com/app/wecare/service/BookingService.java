package com.app.wecare.service;

import com.app.wecare.dto.request.BookingDTO;

public interface BookingService {
    Boolean bookAppointment(BookingDTO bookingDTO);
}
