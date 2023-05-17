package com.example.Vaccinizer.repository;

import com.example.Vaccinizer.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}
