package com.app.wecare.service;

import com.app.wecare.dto.request.BookingDTO;
import com.app.wecare.exception.WecareException;
import com.app.wecare.mapper.BookingMapper;
import com.app.wecare.repository.BookingRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService{
    public static final Log LOGGER = LogFactory.getLog(BookingServiceImpl.class);

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public void bookAppointment(BookingDTO bookingDTO) throws WecareException{
        // check if user doesn't have any other appointment on this slot
        Long userAppointmentsCount = bookingRepository.findCountBookingBetweenSlot(bookingDTO.getUserId(), bookingDTO.getStartTime(), bookingDTO.getEndTime(), bookingDTO.getBookingDate());
        if(userAppointmentsCount > 0){
            LOGGER.error("User has an appointment within this timeslot");
            throw new WecareException("Time slot conflicts with other appointment for the user", 4042);
        }

        // check if user doesn't have any other appointment on this slot
        Long coachAppointmentCount = bookingRepository.findCoachAppointmentCountBookingBetweenSlot(bookingDTO.getCoachId(), bookingDTO.getStartTime(), bookingDTO.getEndTime(), bookingDTO.getBookingDate());
        if(coachAppointmentCount > 0){
            LOGGER.error("Coach has an appointment within this timeslot");
            throw new WecareException("Time slot conflicts with other appointment for the coach", 4042);
        }
        bookingRepository.save(BookingMapper.getBooking(bookingDTO));
    }
}
