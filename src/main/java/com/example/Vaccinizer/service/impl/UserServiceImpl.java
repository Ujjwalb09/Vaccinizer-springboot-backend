package com.example.Vaccinizer.service.impl;

import com.example.Vaccinizer.dto.RequestDTO.UserRequestDto;
import com.example.Vaccinizer.dto.ResponseDTO.UserResponseDto;
import com.example.Vaccinizer.model.User;
import com.example.Vaccinizer.repository.UserRepository;
import com.example.Vaccinizer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserResponseDto addUser(UserRequestDto userRequestDto) {

         //convert request DTO to entity

        User user = new User();
        user.setName(userRequestDto.getName());
        user.setAge(userRequestDto.getAge());
        user.setEmailId(userRequestDto.getEmailId());
        user.setGender(userRequestDto.getGender());
        user.setMobNo(userRequestDto.getMobNo());

        //save the object in DB

        User savedUser = userRepository.save(user);

        //convert the entity to response DTO

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setName(savedUser.getName());
        userResponseDto.setMessage("Congrats! you have registered on Vaccinizer");

        return userResponseDto;
    }
}
