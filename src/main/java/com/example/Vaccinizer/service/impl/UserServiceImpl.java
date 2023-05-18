package com.example.Vaccinizer.service.impl;

import com.example.Vaccinizer.dto.RequestDTO.UserRequestDto;
import com.example.Vaccinizer.dto.ResponseDTO.FindByEmailDto;
import com.example.Vaccinizer.dto.ResponseDTO.NoDoseResponseDto;
import com.example.Vaccinizer.dto.ResponseDTO.UserResponseDto;
import com.example.Vaccinizer.model.User;
import com.example.Vaccinizer.repository.UserRepository;
import com.example.Vaccinizer.service.UserService;
import com.example.Vaccinizer.transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserResponseDto addUser(UserRequestDto userRequestDto) {

         //convert request DTO to entity

//        User user = new User();
//        user.setName(userRequestDto.getName());
//        user.setAge(userRequestDto.getAge());
//        user.setEmailId(userRequestDto.getEmailId());
//        user.setGender(userRequestDto.getGender());
//        user.setMobNo(userRequestDto.getMobNo());

        //creating user object and setting its attributes using builder
//         User user = User.builder()
//                 .name(userRequestDto.getName())
//                 .age(userRequestDto.getAge())
//                 .emailId(userRequestDto.getEmailId())
//                 .gender(userRequestDto.getGender())
//                 .mobNo(userRequestDto.getMobNo())
//                 .build();

        //save the object in DB

        User user = UserTransformer.UserRequestDtoToUser(userRequestDto);
        User savedUser = userRepository.save(user);

        //convert the entity to response DTO

//        UserResponseDto userResponseDto = new UserResponseDto();
//
//        userResponseDto.setName(savedUser.getName());
//        userResponseDto.setMessage("Congrats! you have registered on Vaccinizer");

        //          UserResponseDto userResponseDto = UserResponseDto.builder()
////                  .name(savedUser.getName())
////                  .message("Congrats! you have been registered on Vaccinizer")
//                  .build();


        UserResponseDto userResponseDto = UserTransformer.UserToUserResponseDto(savedUser);

        return userResponseDto;
    }

    @Override
    public FindByEmailDto findByEmailId(String emailId) {

        User user = userRepository.findByEmailId(emailId);

        FindByEmailDto findByEmailDto = new FindByEmailDto();

        findByEmailDto.setName(user.getName());
        findByEmailDto.setAge(user.getAge());
        findByEmailDto.setMobNo(user.getMobNo());
        findByEmailDto.setGender(user.getGender());
        findByEmailDto.setDose2Taken(user.isDose2Taken());
        findByEmailDto.setDose1Taken(user.isDose1Taken());

        return findByEmailDto;
    }

    @Override
    public String updateName(String mobNo, String name) {

       User user = userRepository.findByMobNo(mobNo);

       user.setName(name);

       userRepository.save(user);

       return "Name updated successfully";
    }

    @Override
    public List<NoDoseResponseDto> noDose() {

        List<User> allUser = userRepository.findAll();
        List<NoDoseResponseDto> noDose1 = new ArrayList<>();

        for(User user : allUser)
        {
            if(!user.isDose1Taken() && !user.isDose2Taken())
            {
                NoDoseResponseDto noDoseResponseDto = new NoDoseResponseDto();
                noDoseResponseDto.setName(user.getName());
                noDoseResponseDto.setAge((user.getAge()));
                noDoseResponseDto.setMobNo((user.getMobNo()));
                noDoseResponseDto.setEmailId(user.getEmailId());
                noDose1.add(noDoseResponseDto);
            }
        }

        return noDose1;
    }
}
