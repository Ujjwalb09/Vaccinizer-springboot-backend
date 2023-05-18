package com.example.Vaccinizer.controller;


import com.example.Vaccinizer.dto.RequestDTO.AppointmentRequestDto;
import com.example.Vaccinizer.dto.ResponseDTO.AppointmentResponseDto;
import com.example.Vaccinizer.exception.DoctorNotFoundException;
import com.example.Vaccinizer.exception.NotEligibleForDoseException;
import com.example.Vaccinizer.exception.UserNotFoundException;
import com.example.Vaccinizer.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;
    @PostMapping("/book")
    public ResponseEntity bookAppointment(@RequestBody AppointmentRequestDto appointmentRequestDto) throws UserNotFoundException, DoctorNotFoundException {

        try {
            AppointmentResponseDto appointmentResponseDto = appointmentService.bookAppointment(appointmentRequestDto);
            return new ResponseEntity<>(appointmentResponseDto, HttpStatus.CREATED);
        } catch (UserNotFoundException | DoctorNotFoundException | NotEligibleForDoseException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //generate certificate
      //generate for one dose
      // generate for both doses
}
