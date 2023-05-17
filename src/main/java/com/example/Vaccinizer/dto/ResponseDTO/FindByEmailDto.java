package com.example.Vaccinizer.dto.ResponseDTO;


import com.example.Vaccinizer.Enum.Gender;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FindByEmailDto {

    String name;

    int age;

    String mobNo;

    Gender gender;

    boolean isDose1Taken;

    boolean isDose2Taken;
}
