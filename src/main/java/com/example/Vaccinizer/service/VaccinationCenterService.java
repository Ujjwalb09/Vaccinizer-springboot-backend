package com.example.Vaccinizer.service;

import com.example.Vaccinizer.dto.RequestDTO.CenterRequestDto;
import com.example.Vaccinizer.dto.ResponseDTO.CenterResponseDto;

public interface VaccinationCenterService {

    public CenterResponseDto addCenter(CenterRequestDto centerRequestDto);
}
