package com.example.Vaccinizer.service.impl;

import com.example.Vaccinizer.Enum.DoseNo;
import com.example.Vaccinizer.dto.RequestDTO.AppointmentRequestDto;
import com.example.Vaccinizer.dto.ResponseDTO.AppointmentResponseDto;
import com.example.Vaccinizer.exception.DoctorNotFoundException;
import com.example.Vaccinizer.exception.UserNotFoundException;
import com.example.Vaccinizer.model.*;
import com.example.Vaccinizer.repository.AppointmentRepository;
import com.example.Vaccinizer.repository.DoctorRepository;
import com.example.Vaccinizer.repository.UserRepository;
import com.example.Vaccinizer.service.AppointmentService;
import com.example.Vaccinizer.service.Dose1Service;
import com.example.Vaccinizer.service.Dose2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    Dose1Service dose1Service;
    @Autowired
    Dose2Service dose2Service;

    @Autowired
    AppointmentRepository appointmentRepository;
    @Override
    public AppointmentResponseDto bookApp(AppointmentRequestDto appointmentRequestDto) throws UserNotFoundException, DoctorNotFoundException {

        Optional<User> optionalUser = userRepository.findById(appointmentRequestDto.getUserId());

        if(!optionalUser.isPresent())
        {
            throw new UserNotFoundException("User doesn't exist!");
        }

        User user = optionalUser.get();

        if(appointmentRequestDto.getDoseNo()== DoseNo.DOSE_1){
            Dose1 dose1 = dose1Service.createDose1(user, appointmentRequestDto.getVaccineType());
            user.setDose1Taken(true);
            user.setDose1(dose1);
        }

        else
        {
            Dose2 dose2 = dose2Service.createDose2(user, appointmentRequestDto.getVaccineType());
            user.setDose2Taken(true);
            user.setDose2(dose2);
        }

        Optional<Doctor> optionalDoctor = doctorRepository.findById(appointmentRequestDto.getDoctorId());

        if(!optionalDoctor.isPresent()){
            throw new DoctorNotFoundException("Doctor doesn't exist");
        }

        Doctor doctor = optionalDoctor.get();

        /*
        I have to convert appointment dto to entity and then save it to repo
        then the appointment object it will return will save it to appointment
        list in doctor class
        */

    }
}
