package com.example.Vaccinizer.transformer;

import com.example.Vaccinizer.dto.RequestDTO.CenterRequestDto;
import com.example.Vaccinizer.dto.ResponseDTO.CenterResponseDto;
import com.example.Vaccinizer.model.VaccinationCenter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CenterTransformer {

    public static VaccinationCenter CenterRequestDtoToCenter(CenterRequestDto centerRequestDto)
    {
        return VaccinationCenter.builder()
                .name(centerRequestDto.getName())
                .location(centerRequestDto.getLocation())
                .centerType(centerRequestDto.getCenterType())
                .build();
    }

    public static CenterResponseDto CenterToResponseDto(VaccinationCenter vaccinationCenter)
    {
        return CenterResponseDto.builder()
                .name(vaccinationCenter.getName())
                .location(vaccinationCenter.getLocation())
                .centerType(vaccinationCenter.getCenterType())
                .build();
    }
}
