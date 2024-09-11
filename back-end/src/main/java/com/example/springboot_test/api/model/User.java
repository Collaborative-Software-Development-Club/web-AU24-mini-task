package com.example.springboot_test.api.model;

public class User {
    private String name;
    private Integer id;

    public User(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }
}