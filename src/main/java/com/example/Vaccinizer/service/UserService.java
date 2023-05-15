package com.example.Vaccinizer.service;


import com.example.Vaccinizer.dto.RequestDTO.UserRequestDto;
import com.example.Vaccinizer.dto.ResponseDTO.UserResponseDto;
import com.example.Vaccinizer.model.User;

public interface UserService {

        public UserResponseDto addUser(UserRequestDto userRequestDto);
}
