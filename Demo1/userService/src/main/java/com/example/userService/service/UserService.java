package com.example.userService.service;

import com.example.userService.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUser();
    User getUser(String userId);
}
