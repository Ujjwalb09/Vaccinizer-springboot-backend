package com.example.Vaccinizer.model;

import com.example.Vaccinizer.Enum.CenterType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity //annotation used to map class to the table in a database
@Data
//annotation that will all the basic lombok library annotation such as getter and setters and required args constructor
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) //will make all attributes as private. so we don't have to write private in front of all attributes.
public class VaccinationCenter {

    @Id //annotation used to define that this attribute will become primary key in the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //will auto generate primary key in the table
    int id;

    @Column(name="name")
    String name;

    @Column(name="location")
    String location;

    @Column(name="centerType")
    @Enumerated(EnumType.STRING)
    CenterType centerType;

    @OneToMany(mappedBy = "vaccinationCenter", cascade = CascadeType.ALL)
    List<Doctor> doctors = new ArrayList<>();

}
