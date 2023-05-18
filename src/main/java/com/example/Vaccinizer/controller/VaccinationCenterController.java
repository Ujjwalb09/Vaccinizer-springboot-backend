package com.example.Vaccinizer.controller;


import com.example.Vaccinizer.dto.RequestDTO.CenterRequestDto;
import com.example.Vaccinizer.dto.ResponseDTO.CenterResponseDto;
import com.example.Vaccinizer.service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/center")
public class VaccinationCenterController {

    @Autowired
    VaccinationCenterService vaccinationCenterService;

    @PostMapping("/add")
    public ResponseEntity addVaccinationCenter(@RequestBody CenterRequestDto centerRequestDto){

        CenterResponseDto centerResponseDto = vaccinationCenterService.addCenter(centerRequestDto);
        return new ResponseEntity<>(centerResponseDto, HttpStatus.CREATED);
    }

    //give the list of all doctor at particular center(centerId)
    //give the list of all male doctor at particular center(centerId)
    //give the list of all female doctor at particular center(centerId)
    //all male dr above age 40
    //give all center of a particular center type

}
