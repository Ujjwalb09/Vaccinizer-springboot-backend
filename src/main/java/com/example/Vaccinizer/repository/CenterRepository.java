package com.example.Vaccinizer.repository;

import com.example.Vaccinizer.model.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CenterRepository extends JpaRepository<VaccinationCenter, Integer> {
}
