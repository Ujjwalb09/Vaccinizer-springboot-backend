package com.example.Vaccinizer.service;


import com.example.Vaccinizer.dto.RequestDTO.UserRequestDto;
import com.example.Vaccinizer.dto.ResponseDTO.FindByEmailDto;
import com.example.Vaccinizer.dto.ResponseDTO.NoDoseResponseDto;
import com.example.Vaccinizer.dto.ResponseDTO.UserResponseDto;
import com.example.Vaccinizer.model.User;

import java.util.List;

public interface UserService {

        public UserResponseDto addUser(UserRequestDto userRequestDto);

        FindByEmailDto findByEmailId(String emailId);

        String updateName(String mobNo, String name);

        List<NoDoseResponseDto> noDose();

}
