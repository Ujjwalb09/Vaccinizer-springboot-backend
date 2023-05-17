package com.example.Vaccinizer.transformer;

import com.example.Vaccinizer.dto.RequestDTO.DoctorRequestDto;
import com.example.Vaccinizer.dto.ResponseDTO.CenterResponseDto;
import com.example.Vaccinizer.dto.ResponseDTO.DoctorResponseDto;
import com.example.Vaccinizer.model.Doctor;

public class DoctorTransformer {

    public static Doctor DoctorRequestDtoToDoctor(DoctorRequestDto doctorRequestDto){

        return Doctor.builder()
                .name(doctorRequestDto.getName())
                .age(doctorRequestDto.getAge())
                .mobNo(doctorRequestDto.getMobNo())
                .gender(doctorRequestDto.getGender())
                .emailId(doctorRequestDto.getEmailId())
                .build();
    }

    public static DoctorResponseDto DoctorToDoctorResponseDto(Doctor doctor) {

        CenterResponseDto centerResponseDto = CenterTransformer.CenterToResponseDto(doctor.getVaccinationCenter());
        return DoctorResponseDto.builder()
                .name(doctor.getName())
                .emailId(doctor.getEmailId())
                .mobNo(doctor.getMobNo())
                .centerResponseDto(centerResponseDto)
                .build();
    }
}
