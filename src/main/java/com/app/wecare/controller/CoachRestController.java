package com.app.wecare.controller;

import com.app.wecare.dto.request.CoachRequest;
import com.app.wecare.dto.request.LoginRequest;
import com.app.wecare.dto.response.ErrorResponse;
import com.app.wecare.dto.response.GenericResponse;
import com.app.wecare.entity.Booking;
import com.app.wecare.entity.Coach;
import com.app.wecare.exception.WecareException;
import com.app.wecare.mapper.CoachMapper;
import com.app.wecare.service.CoachService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/coaches")
public class CoachRestController {

    @Autowired
    CoachService coachService;
    private static final Log LOGGER = LogFactory.getLog(CoachRestController.class);

    @PostMapping( consumes = "application/json")
    ResponseEntity<GenericResponse> createCoach(@RequestHeader(value = "source-system") final String sourceSystem,
                                                @Valid @RequestBody CoachRequest coach, Errors errors) {
        LOGGER.info("createCoach Rest API invoked");

        if(errors.hasErrors()){
            String errMsg = errors.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(","));
            ErrorResponse errorResponse = new ErrorResponse(errMsg);
            errorResponse.setCode(401);
            return ResponseEntity.ok(errorResponse);
        }
        Coach coach1 = CoachMapper.mapCoach(coach);
        String msg = coachService.addCoach(coach1);
        GenericResponse response = new GenericResponse();
        response.setCode(200);
        response.setMessage(msg);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/login", consumes = "application/json")
    ResponseEntity<Boolean> loginCoach(@RequestHeader(value = "source-system") final String sourceSystem,
                                       @Valid @RequestBody LoginRequest loginRequest) {
        return  ResponseEntity.ok(coachService.loginCoach(loginRequest));
    }

    @GetMapping(value = "{coachId}")
    ResponseEntity<GenericResponse> getCoachProfile(@PathVariable Long coachId) throws WecareException{
        Coach coach = coachService.fetchCoachByCoachId(coachId);
        GenericResponse response = new GenericResponse();
        response.setCode(200);
        response.setData(coach);
        response.setMessage("Found the coach");
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/all")
    ResponseEntity<GenericResponse> showAllCoaches(){
        List<Coach> coaches = coachService.fetchAllCoach();
        GenericResponse response = new GenericResponse();
        response.setCode(200);
        response.setMessage("All coaches");
        response.setData(coaches);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/booking/{coachId}", produces = "application/json")
    ResponseEntity<GenericResponse> showMySchedule(@PathVariable Long coachId) {
        List<Booking> bookings = coachService.fetchAllBookingCoachByCoachId(coachId);
        String message = null;
        if (bookings.isEmpty()) {
            message = "No Schedule for you!!!";
        } else {
            message = "You have " + bookings.size() + " appointments!!";
        }
        return ResponseEntity.ok().body(GenericResponse.builder().code(200).message(message).data(bookings).build());
    }


    @GetMapping
    ResponseEntity<String> health(){
        return new ResponseEntity<>("I am working", HttpStatus.OK);
    }
}
