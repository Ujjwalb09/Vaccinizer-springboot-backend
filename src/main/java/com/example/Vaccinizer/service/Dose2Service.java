package com.example.Vaccinizer.service;

import com.example.Vaccinizer.Enum.VaccineType;
import com.example.Vaccinizer.model.Dose2;
import com.example.Vaccinizer.model.User;

public interface Dose2Service {

    public Dose2 createDose2(User user, VaccineType vaccineType);
}
