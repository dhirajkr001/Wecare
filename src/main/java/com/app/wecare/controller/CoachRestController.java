package com.app.wecare.controller;

import com.app.wecare.dto.request.CoachDTO;
import com.app.wecare.dto.response.ErrorResponse;
import com.app.wecare.dto.response.GenericResponse;
import com.app.wecare.entity.Coach;
import com.app.wecare.exception.WecareException;
import com.app.wecare.mapper.CoachMapper;
import com.app.wecare.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/wecare")
public class CoachRestController {

    @Autowired
    CoachService coachService;

    @PostMapping(value = "/coaches", consumes = "application/json")
    ResponseEntity<GenericResponse> createCoach(@Valid @RequestBody CoachDTO coach, Errors errors) throws WecareException {
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

    @GetMapping
    ResponseEntity<String> health(){
        return new ResponseEntity<>("I am working", HttpStatus.OK);
    }
}
