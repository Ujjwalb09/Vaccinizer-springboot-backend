package com.example.Vaccinizer.service;

import com.example.Vaccinizer.dto.RequestDTO.DoctorRequestDto;
import com.example.Vaccinizer.dto.ResponseDTO.DoctorResponseDto;
import com.example.Vaccinizer.exception.CenterNotPresentException;

public interface DoctorService {

    public DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto) throws CenterNotPresentException;
}
