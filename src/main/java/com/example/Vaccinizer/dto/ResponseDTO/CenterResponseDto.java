package com.example.Vaccinizer.dto.ResponseDTO;


import com.example.Vaccinizer.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data//annotation that will all the basic lombok library annotation such as getter and setters and required args constructor
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CenterResponseDto {

    String name;

    String location;

    CenterType centerType;
}
