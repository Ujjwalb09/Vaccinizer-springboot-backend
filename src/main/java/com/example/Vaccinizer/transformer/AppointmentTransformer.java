package com.example.Vaccinizer.transformer;

import com.example.Vaccinizer.Enum.VaccineType;
import com.example.Vaccinizer.dto.RequestDTO.AppointmentRequestDto;
import com.example.Vaccinizer.dto.ResponseDTO.AppointmentResponseDto;
import com.example.Vaccinizer.dto.ResponseDTO.CenterResponseDto;
import com.example.Vaccinizer.model.Appointment;
import com.example.Vaccinizer.model.Doctor;
import com.example.Vaccinizer.model.User;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@UtilityClass
public class AppointmentTransformer {

    @Autowired
    CenterResponseDto centerResponseDto;
    public static Appointment AppointmentRequestDtoToAppointment(AppointmentRequestDto appointmentRequestDto, User user, Doctor doctor){

        Appointment appointment = Appointment.builder()
                .doseNo(appointmentRequestDto.getDoseNo())
                .appointmentNo(String.valueOf(UUID.randomUUID()))
                .user(user)
                .doctor(doctor)
                .build();

        return appointment;
    }

    public static AppointmentResponseDto AppointmentToAppointmentResponseDto(Appointment appointment, VaccineType vaccineType) {

        CenterResponseDto centerResponseDto = CenterTransformer.CenterToResponseDto(appointment.getDoctor().getVaccinationCenter());

        return AppointmentResponseDto.builder()
                .userName(appointment.getUser().getName())
                .appointmentNo(appointment.getAppointmentNo())
                .dateOfAppointment(appointment.getDateOfAppointment())
                .name(appointment.getDoctor().getName())
                .doseNo(appointment.getDoseNo())
                .centerResponseDto(centerResponseDto)
                .vaccineType(vaccineType)
                .build();
    }
}
