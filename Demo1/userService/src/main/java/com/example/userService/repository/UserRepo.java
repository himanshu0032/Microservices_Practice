package com.example.userService.repository;

import com.example.userService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {

}
