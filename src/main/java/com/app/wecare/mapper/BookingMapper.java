package com.app.wecare.mapper;

import com.app.wecare.dto.request.BookingDTO;
import com.app.wecare.entity.Booking;

public class BookingMapper {
    public static Booking getBooking(BookingDTO bookingDTO){
        Booking booking = new Booking();
        booking.setBookingDate(bookingDTO.getBookingDate());
        booking.setCoachId(bookingDTO.getCoachId());
        booking.setUserId(bookingDTO.getUserId());
        booking.setStartTime(bookingDTO.getStartTime());
        booking.setEndTime(bookingDTO.getEndTime());
        return booking;
    }
}
