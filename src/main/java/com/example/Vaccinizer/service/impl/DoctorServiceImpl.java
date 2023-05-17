package com.example.Vaccinizer.service.impl;

import com.example.Vaccinizer.dto.RequestDTO.DoctorRequestDto;
import com.example.Vaccinizer.dto.ResponseDTO.DoctorResponseDto;
import com.example.Vaccinizer.exception.CenterNotPresentException;
import com.example.Vaccinizer.model.Doctor;
import com.example.Vaccinizer.model.VaccinationCenter;
import com.example.Vaccinizer.repository.CenterRepository;
import com.example.Vaccinizer.service.DoctorService;
import com.example.Vaccinizer.transformer.DoctorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    CenterRepository centerRepository;
    @Override
    public DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto) throws CenterNotPresentException {

            /*
            optional represents that center can be or cannot be null. We are using optional as it not mandatory
            that we will get center object by center Id everytime, we can get null as well that's why we use optional
            */
        Optional<VaccinationCenter> optionalCenter =  centerRepository.findById(doctorRequestDto.getCenterId());

        if(!optionalCenter.isPresent()){
            throw new CenterNotPresentException("Invalid center Id!");
        }

        VaccinationCenter center = optionalCenter.get();

        //dto to entity
        Doctor doctor = DoctorTransformer.DoctorRequestDtoToDoctor(doctorRequestDto);
        doctor.setVaccinationCenter(center);
        //add doctor to current list of that center
        center.getDoctors().add(doctor);

        VaccinationCenter savedCenter = centerRepository.save(center);

        //entity to response dto

        return DoctorTransformer.DoctorToDoctorResponseDto(doctor);
    }
}
