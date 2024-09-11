package com.example.springboot_test.service;

import org.springframework.stereotype.Service;

import com.example.springboot_test.api.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private List<User> users;

    public UserService() {
        this.users = new ArrayList<>();
        users.add(new User(1, "John"));
        users.add(new User(2, "Mary"));
        users.add(new User(3, "Terry"));

    }

    public Optional<User> getUser(Integer id) {
        for (User user : users) {
            if (user.getId() == id) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}