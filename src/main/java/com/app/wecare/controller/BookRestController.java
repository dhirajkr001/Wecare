package com.app.wecare.controller;

import com.app.wecare.dto.request.BookingDTO;
import com.app.wecare.dto.response.GenericResponse;
import com.app.wecare.exception.WecareException;
import com.app.wecare.service.BookingService;
import com.app.wecare.validation.ModelValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<GenericResponse> bookAppointment(@Valid @RequestBody BookingDTO bookingDTO)
            throws WecareException, SQLIntegrityConstraintViolationException {
        modelValidator.bookingValidator(bookingDTO);
        bookingService.bookAppointment(bookingDTO);
        return ResponseEntity.ok(GenericResponse.builder().code(200).message("Success").build());
    }
}
