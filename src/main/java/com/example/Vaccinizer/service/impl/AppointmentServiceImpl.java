package com.example.Vaccinizer.service.impl;

import com.example.Vaccinizer.Enum.DoseNo;
import com.example.Vaccinizer.dto.RequestDTO.AppointmentRequestDto;
import com.example.Vaccinizer.dto.ResponseDTO.AppointmentResponseDto;
import com.example.Vaccinizer.exception.DoctorNotFoundException;
import com.example.Vaccinizer.exception.NotEligibleForDoseException;
import com.example.Vaccinizer.exception.UserNotFoundException;
import com.example.Vaccinizer.model.*;
import com.example.Vaccinizer.repository.AppointmentRepository;
import com.example.Vaccinizer.repository.DoctorRepository;
import com.example.Vaccinizer.repository.UserRepository;
import com.example.Vaccinizer.service.AppointmentService;
import com.example.Vaccinizer.service.Dose1Service;
import com.example.Vaccinizer.service.Dose2Service;
import com.example.Vaccinizer.transformer.AppointmentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Autowired
    private JavaMailSender emailSender;
    @Override
    public AppointmentResponseDto bookAppointment(AppointmentRequestDto appointmentRequestDto) throws UserNotFoundException, DoctorNotFoundException, NotEligibleForDoseException {

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

        else{
            if(!user.isDose1Taken()){
                throw new NotEligibleForDoseException("Sorry you are not eligible for Dose 2");
            }

            Dose2 dose2 = dose2Service.createDose2(user, appointmentRequestDto.getVaccineType());
            user.setDose2Taken(true);
            user.setDose2(dose2);

        }

        Optional<Doctor> optionalDoctor = doctorRepository.findById(appointmentRequestDto.getDoctorId());

        if(!optionalDoctor.isPresent()){
            throw new DoctorNotFoundException("Doctor doesn't exist");
        }

        Doctor doctor = optionalDoctor.get();

        Appointment appointment = AppointmentTransformer.AppointmentRequestDtoToAppointment(appointmentRequestDto, user, doctor);

        user.getAppointments().add(appointment);
        User savedUser = userRepository.save(user); //save dose1 or dose2 and appointment

        Appointment savedAppointment = savedUser.getAppointments().get(savedUser.getAppointments().size()-1);
        doctor.getAppointments().add(savedAppointment);


        //send email

        String text = "Congrats!!" + user.getName() + "Your dose" + appointmentRequestDto.getDoseNo() + "has been booked";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo(user.getEmailId());
        message.setSubject("Appointment Booked");
        message.setText(text);
        emailSender.send(message);

        //entity to response dto conversion

        return AppointmentTransformer.AppointmentToAppointmentResponseDto(savedAppointment , appointmentRequestDto.getVaccineType());

    }
}
