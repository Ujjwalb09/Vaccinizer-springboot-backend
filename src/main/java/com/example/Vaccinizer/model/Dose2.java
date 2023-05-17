package com.example.Vaccinizer.model;

import com.example.Vaccinizer.Enum.VaccineType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity //annotation used to map class to the table in a database
@Data //annotation that will all the basic lombok library annotation such as getter and setters and required args constructor
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) //will make all attributes as private. so we don't have to write private in front of all attributes.
@Builder
public class Dose2 {

    @Id //annotation used to define that this attribute will become primary key in the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //will auto generate primary key in the table
    int id;

    @Column(name="doseId")
    String doseId;

    @Column(name="vaccineType")
    @Enumerated(EnumType.STRING)
    VaccineType vaccineType;

    @Column(name="vaccinationDate")
    @CreationTimestamp
    Date vaccinationDate;

    @OneToOne
    @JoinColumn
    User user;
}
