package com.example.Vaccinizer.controller;


import com.example.Vaccinizer.dto.RequestDTO.UserRequestDto;
import com.example.Vaccinizer.dto.ResponseDTO.FindByEmailDto;
import com.example.Vaccinizer.dto.ResponseDTO.NoDoseResponseDto;
import com.example.Vaccinizer.dto.ResponseDTO.UserResponseDto;
import com.example.Vaccinizer.model.User;
import com.example.Vaccinizer.service.UserService;
import com.example.Vaccinizer.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user") //adds common endpoints to all APIs
public class UserController {


    @Autowired
    UserService userService;
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody UserRequestDto userRequestDto)
    {
          UserResponseDto userResponseDto = userService.addUser(userRequestDto);
          return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/findByEmailId")
    public ResponseEntity findByEmailId(@RequestParam("emailId") String emailId)
    {
        FindByEmailDto findByEmailDto = userService.findByEmailId(emailId);

        return new ResponseEntity<>(findByEmailDto, HttpStatus.CREATED);
    }

    @PutMapping("/updateName")
    public ResponseEntity updateName(@RequestParam("mobNo") String mobNo, @RequestParam("name") String name)
    {
        String message = userService.updateName(mobNo, name);

        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping("/notTakenASingleDose")
    public ResponseEntity noDose()
    {
        List<NoDoseResponseDto> noDoseResponseDto = userService.noDose();

        return new ResponseEntity<>(noDoseResponseDto, HttpStatus.CREATED);
    }

    //find by emailID

    //update the name of the user based on mobNo

    // all the users who have not taken even a single dose

    //find all users who have taken dose 1 but not dose 2

    //users who are fully vaccinated

    //all male users who have not taken even a single vaccine
}
