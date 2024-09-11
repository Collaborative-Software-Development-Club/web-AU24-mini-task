package com.example.springboot_test.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.springboot_test.api.model.User;
import com.example.springboot_test.service.UserService;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public User getUser(@RequestParam Integer id) {
        Optional<User> user = userService.getUser(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}