package com.example.Vaccinizer.service.impl;

import com.example.Vaccinizer.Enum.VaccineType;
import com.example.Vaccinizer.model.Dose1;
import com.example.Vaccinizer.model.User;
import com.example.Vaccinizer.service.Dose1Service;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Dose1ServiceImpl implements Dose1Service {
    @Override
    public Dose1 createDose1(User user, VaccineType vaccineType) {

        Dose1 dose1 = Dose1.builder()
                .doseId(String.valueOf(UUID.randomUUID()))
                .vaccineType(vaccineType)
                .user(user)
                .build();

        return dose1;
    }
}
