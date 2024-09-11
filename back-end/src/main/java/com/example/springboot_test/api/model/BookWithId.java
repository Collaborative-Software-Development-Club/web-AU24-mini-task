package com.example.springboot_test.api.model;

public class BookWithId extends Book {
    private Integer id;
    private static int count = 0;

    public BookWithId(String title, String author, String synopsys, String releaseDate) {
        super(title, author, synopsys, releaseDate);
        this.id = count;
        incrementCount();

    }

    private static void incrementCount() {
        count++;
    }

    public Integer getId() {
        return this.id;
    }

}