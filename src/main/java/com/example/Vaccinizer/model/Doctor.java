package com.example.Vaccinizer.model;

import com.example.Vaccinizer.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity //annotation used to map class to the table in a database
@Data
//annotation that will all the basic lombok library annotation such as getter and setters and required args constructor
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) //will make all attributes as private. so we don't have to write private in front of all attributes.
@Builder
public class Doctor {

    @Id //annotation used to define that this attribute will become primary key in the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //will auto generate primary key in the table
    int id;

    @Column(name="name") //annotation used to specify column name
    String name;

    @Column(name = "age")
    int age;

    @Column(name =  "email_id", unique = true, nullable = false) //unique = true, nullable = false. This will keep this field unique and not null in the table
    String emailId;

    @Column(name = "mob_no", unique = true, nullable = false)
    String mobNo;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING) //this annotation is used so that sql can convert enum data types to data types it can understand
    Gender gender;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    List<Appointment> appointments = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    VaccinationCenter vaccinationCenter;
}
