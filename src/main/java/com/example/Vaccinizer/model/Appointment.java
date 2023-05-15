package com.example.Vaccinizer.model;

import com.example.Vaccinizer.Enum.DoseNo;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity //annotation used to map class to the table in a database
@Data
//annotation that will all the basic lombok library annotation such as getter and setters and required args constructor
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) //will make all attributes as private. so we don't have to write private in front of all attributes.
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name="appointmentNo")
    String appointmentNo; //will generate using UUID

    @Column(name="dateOfAppointment")
    @CreationTimestamp
    Date dateOfAppointment;

    @Column(name="doseNo")
    @Enumerated(EnumType.STRING)
    DoseNo doseNo;

    @ManyToOne
    @JoinColumn //annotation used to introduce parent's primary key as foreign key in child table
    User user; //attribute to connect child class to parent class

    @ManyToOne
    @JoinColumn
    Doctor doctor;

}
