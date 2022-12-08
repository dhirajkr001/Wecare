package com.app.wecare.controller;

import com.app.wecare.dto.request.BookingRequest;
import com.app.wecare.dto.request.BookingRescheduleRequest;
import com.app.wecare.dto.response.GenericResponse;
import com.app.wecare.exception.WecareException;
import com.app.wecare.service.BookingService;
import com.app.wecare.validation.ModelValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLIntegrityConstraintViolationException;

@RestController
@RequestMapping("/appointments")
public class BookRestController {

    @Autowired
    BookingService bookingService;

    @Autowired
    ModelValidator modelValidator;

    @PostMapping(value = "/booking", produces = "application/json")
    public ResponseEntity<GenericResponse> bookAppointment(@Valid @RequestBody BookingRequest bookingRequest)
            throws WecareException, SQLIntegrityConstraintViolationException {
        modelValidator.bookingValidator(bookingRequest);
        bookingService.bookAppointment(bookingRequest);
        return ResponseEntity.ok(GenericResponse.builder().code(200).message("Success").build());
    }

    @PostMapping(value = "/booking/{bookingId}", consumes = "application/json")
    public ResponseEntity<GenericResponse> rescheduleAppointment(@Valid @RequestBody BookingRescheduleRequest bookingRescheduleRequest,  @PathVariable Long bookingId)
        throws WecareException {
        bookingService.rescheduleAppointment(bookingRescheduleRequest, bookingId);
        return ResponseEntity.ok(GenericResponse.builder().code(200).message("Reschedule Success").build());
    }

    @DeleteMapping(value = "/booking/{bookingId}")
    public ResponseEntity<GenericResponse> deleteAppointment(@PathVariable Long bookingId) throws EmptyResultDataAccessException {
        bookingService.deleteAppointment(bookingId);
        return ResponseEntity.ok(GenericResponse.builder().code(200).message("Deletion Successful").build());
    }
}
