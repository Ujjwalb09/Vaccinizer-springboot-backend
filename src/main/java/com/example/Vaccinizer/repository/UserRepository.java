package com.example.Vaccinizer.repository;

import com.example.Vaccinizer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmailId(String emailId);

    User findByMobNo(String mobNo);

}
