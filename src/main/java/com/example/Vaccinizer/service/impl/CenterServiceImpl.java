package com.example.Vaccinizer.service.impl;

import com.example.Vaccinizer.dto.RequestDTO.CenterRequestDto;
import com.example.Vaccinizer.dto.ResponseDTO.CenterResponseDto;
import com.example.Vaccinizer.model.VaccinationCenter;
import com.example.Vaccinizer.repository.CenterRepository;
import com.example.Vaccinizer.service.VaccinationCenterService;
import com.example.Vaccinizer.transformer.CenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CenterServiceImpl implements VaccinationCenterService {


    @Autowired
    CenterRepository centerRepository;
    @Override
    public CenterResponseDto addCenter(CenterRequestDto centerRequestDto) {

        //convert request dto to entity inside transformer
        VaccinationCenter vaccinationCenter = CenterTransformer.CenterRequestDtoToCenter(centerRequestDto);
        //save center to your database
        VaccinationCenter savedCenter =  centerRepository.save(vaccinationCenter);

        //convert entity to response dto inside transformer
        CenterResponseDto centerResponseDto = CenterTransformer.CenterToResponseDto(savedCenter);

        return centerResponseDto;
    }
}
