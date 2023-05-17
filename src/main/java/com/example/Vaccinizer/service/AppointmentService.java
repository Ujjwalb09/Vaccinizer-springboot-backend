package com.example.Vaccinizer.service;

import com.example.Vaccinizer.dto.RequestDTO.AppointmentRequestDto;
import com.example.Vaccinizer.dto.ResponseDTO.AppointmentResponseDto;
import com.example.Vaccinizer.exception.DoctorNotFoundException;
import com.example.Vaccinizer.exception.UserNotFoundException;

public interface AppointmentService {

    public AppointmentResponseDto bookApp(AppointmentRequestDto appointmentRequestDto) throws UserNotFoundException, DoctorNotFoundException;
}
