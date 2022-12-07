package com.app.wecare.service;

import com.app.wecare.dto.request.BookingDTO;
import com.app.wecare.mapper.BookingMapper;
import com.app.wecare.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public Boolean bookAppointment(BookingDTO bookingDTO) {
        bookingRepository.save(BookingMapper.getBooking(bookingDTO));
        return true;

    }
}
