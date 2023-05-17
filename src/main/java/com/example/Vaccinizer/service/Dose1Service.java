package com.example.Vaccinizer.service;

import com.example.Vaccinizer.Enum.VaccineType;
import com.example.Vaccinizer.model.Dose1;
import com.example.Vaccinizer.model.User;

public interface Dose1Service {

    public Dose1 createDose1(User user, VaccineType vaccineType);
}
