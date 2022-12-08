package com.app.wecare.mapper;

import com.app.wecare.dto.request.BookingRequest;
import com.app.wecare.entity.Booking;

public class BookingMapper {
    public static Booking getBooking(BookingRequest bookingRequest){
        Booking booking = new Booking();
        booking.setBookingDate(bookingRequest.getBookingDate());
        booking.setCoachId(bookingRequest.getCoachId());
        booking.setUserId(bookingRequest.getUserId());
        booking.setStartTime(bookingRequest.getStartTime());
        booking.setEndTime(bookingRequest.getEndTime());
        return booking;
    }
}
