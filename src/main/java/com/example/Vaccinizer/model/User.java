package com.example.Vaccinizer.model;

import com.example.Vaccinizer.Enum.Gender;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity //annotation used to map class to the table in a database
@Data //annotation that will import all the basic lombok library annotation such as getter and setters and required args constructor
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) //will make all attributes as private. so we don't have to write private in front of all attributes.
@Table(name="user") //annotation used to specify table name in database
public class User {

    @Id //annotation used to define that this attribute will become primary key in the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //will auto generate primary key in the table
    int id;

    @Column(name="name") //annotation used to specify column name
    String name;

    @Column(name = "age")
    int age;

    @Column(name = "email_id", unique = true, nullable = false) //unique = true, nullable = false. This will keep this field unique and not null in the table
    String emailId;

    @Column(name = "mob_no", unique = true, nullable = false)
    String mobNo;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(name="is_dose1_taken")
    boolean isDose1Taken;

    @Column(name="is_dose2_taken")
    boolean isDose2Taken;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Appointment> appointments = new ArrayList<>(); //to establish the relation with many side we will use the reference of List type
                                                        //initializing empty arrayList as user will have no appointments the time of registering

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    Dose1 dose1;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    Dose2 dose2;
}
