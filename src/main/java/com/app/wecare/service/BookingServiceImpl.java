package com.app.wecare.service;

import com.app.wecare.dto.request.BookingRequest;
import com.app.wecare.dto.request.BookingRescheduleRequest;
import com.app.wecare.entity.Booking;
import com.app.wecare.exception.WecareException;
import com.app.wecare.mapper.BookingMapper;
import com.app.wecare.repository.BookingRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService{
    public static final Log LOGGER = LogFactory.getLog(BookingServiceImpl.class);

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public void bookAppointment(BookingRequest bookingRequest) throws WecareException{
        // check if user doesn't have any other appointment on this slot
        Long userAppointmentsCount = bookingRepository.findCountBookingBetweenSlot(bookingRequest.getUserId(), bookingRequest.getStartTime(), bookingRequest.getEndTime(), bookingRequest.getBookingDate());
        if(userAppointmentsCount > 0){
            LOGGER.error("User has an appointment within this timeslot");
            throw new WecareException("Time slot conflicts with other appointment for the user", 4042);
        }

        // check if user doesn't have any other appointment on this slot
        Long coachAppointmentCount = bookingRepository.findCoachAppointmentCountBookingBetweenSlot(bookingRequest.getCoachId(), bookingRequest.getStartTime(), bookingRequest.getEndTime(), bookingRequest.getBookingDate());
        if(coachAppointmentCount > 0){
            LOGGER.error("Coach has an appointment within this timeslot");
            throw new WecareException("Time slot conflicts with other appointment for the coach", 4042);
        }
        bookingRepository.save(BookingMapper.getBooking(bookingRequest));
    }

    @Override
    public void rescheduleAppointment(BookingRescheduleRequest bookingRescheduleRequest, Long bookingId) throws WecareException {
        //check if booking id is correct
        Optional<Booking> booking = bookingRepository.findById(bookingId);
        if(booking.isEmpty()){
            LOGGER.error("No booking exists for this booking Id");
            throw new WecareException("No booking exists for this booking Id", 4043);
        }

        // check if user doesn't have any other appointment on this slot
        Long userAppointmentsCount = bookingRepository.findCountBookingBetweenSlot(booking.get().getUserId(),
                bookingRescheduleRequest.getStartTime(), bookingRescheduleRequest.getEndTime(), bookingRescheduleRequest.getBookingDate());
        if(userAppointmentsCount > 0){
            LOGGER.error("User has an appointment within this timeslot");
            throw new WecareException("Time slot conflicts with other appointment for the user", 4042);
        }

        // check if user doesn't have any other appointment on this slot
        Long coachAppointmentCount = bookingRepository.findCoachAppointmentCountBookingBetweenSlot(booking.get().getCoachId(),
                bookingRescheduleRequest.getStartTime(), bookingRescheduleRequest.getEndTime(), bookingRescheduleRequest.getBookingDate());
        if(coachAppointmentCount > 0){
            LOGGER.error("Coach has an appointment within this timeslot");
            throw new WecareException("Time slot conflicts with other appointment for the coach", 4042);
        }

        booking.get().setStartTime(bookingRescheduleRequest.getStartTime());
        booking.get().setEndTime(bookingRescheduleRequest.getEndTime());
        booking.get().setBookingDate(bookingRescheduleRequest.getBookingDate());
        bookingRepository.save(booking.get());
    }

    @Override
    public void deleteAppointment(Long bookingId) throws EmptyResultDataAccessException {
        bookingRepository.deleteById(bookingId);
    }
}
