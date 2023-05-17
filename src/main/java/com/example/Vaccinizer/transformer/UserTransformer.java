package com.example.Vaccinizer.transformer;

import com.example.Vaccinizer.dto.RequestDTO.UserRequestDto;
import com.example.Vaccinizer.dto.ResponseDTO.UserResponseDto;
import com.example.Vaccinizer.model.User;
import lombok.experimental.UtilityClass;

@UtilityClass // we will not create object of this class
public class UserTransformer {

    public static User UserRequestDtoToUser(UserRequestDto userRequestDto)
    {
          return User.builder()
                  .name(userRequestDto.getName())
                  .age(userRequestDto.getAge())
                  .emailId(userRequestDto.getEmailId())
                  .gender(userRequestDto.getGender())
                  .mobNo(userRequestDto.getMobNo())
                  .build();
    }

    public static UserResponseDto UserToUserResponseDto(User user)
    {
        return UserResponseDto.builder()
                .name(user.getName())
                .message("Congrats! you have been registered on Vaccinizer")
                .build();
    }
}
