package com.app.wecare.validation;

import com.app.wecare.dto.request.BookingRequest;
import com.app.wecare.exception.WecareException;
import com.app.wecare.repository.CoachRepository;
import com.app.wecare.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class ModelValidator {
    private static final Log LOGGER = LogFactory.getLog(ModelValidator.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    CoachRepository coachRepository;

    public void bookingValidator(BookingRequest bookingRequest) throws WecareException {
        coachIdValidator(bookingRequest.getCoachId());
        userIdValidator(bookingRequest.getUserId());
        bookingTimeValidator(bookingRequest);
    }

    public void bookingTimeValidator(BookingRequest bookingRequest) throws WecareException {
        LocalTime startTime = bookingRequest.getStartTime();
        LocalTime endTime = bookingRequest.getEndTime();
        LocalDate bookingDate = bookingRequest.getBookingDate();
        LocalDateTime current = LocalDateTime.now();

        if (startTime.isAfter(endTime)) {
            LOGGER.error("Start Time is greater than end Time");
            throw new WecareException("Start time is greater than end time", 4040);
        } else if (current.isAfter(LocalDateTime.of(bookingDate, startTime))) {
            LOGGER.error("Cannot book appointment for past time");
            throw new WecareException("Cannot book appointment for past time", 4040);
        } else if (endTime.minusMinutes(60).isAfter(startTime)) {
            LOGGER.error("Maximum duration can be 60 minutes");
            throw new WecareException("Maximum slot duration can be 60 minutes", 4040);
        } else if (endTime.minusMinutes(15).isBefore(startTime)) {
            LOGGER.error("Minimum duration should be 15 minutes");
            throw new WecareException("Minimum slot duration can be 15 minutes", 4040);

        }

    }

    /**
     * Removing this method, instead of first checking if we can insert and then inserting is a bad idea
     * I can directly try to insert and if I get an error I can handle that.
     */
    public void coachIdValidator(Long coachId) throws WecareException {
//        Optional<Coach> coach = coachRepository.findById(coachId);
//        if (coach.isEmpty()) {
//            LOGGER.error("Coach Id Invalid");
//            throw new WecareException("Coach Id Invalid", 4040);
//        }
    }

    /**
     * Removing this method, instead of first checking if we can insert and then inserting is a bad idea
     * I can directly try to insert and if I get an error I can handle that.
     */
    public void userIdValidator(Long userId) throws WecareException {
//        Optional<User> user = userRepository.findById(userId);
//        if (user.isEmpty()) {
//            LOGGER.error("User Id Invalid");
//            throw new WecareException("User  Id Invalid", 4040);
//        }
    }
}
