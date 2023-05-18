package com.example.Vaccinizer.dto.ResponseDTO;

import com.example.Vaccinizer.Enum.DoseNo;
import com.example.Vaccinizer.Enum.VaccineType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
//annotation that will all the basic lombok library annotation such as getter and setters and required args constructor
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AppointmentResponseDto {

    String userName;

    String appointmentNo;

    Date dateOfAppointment;

    DoseNo doseNo;

    String name;

    CenterResponseDto centerResponseDto;

    VaccineType vaccineType;
}
