package com.example.springboot_test.api.model;

public class Book {
    private String title;
    private String author;
    private String synopsys;
    private String releaseDate;
    private Integer id;

    public Book(String title, String author, String synopsys, String releaseDate) {
        this.title = title;
        this.author = author;
        this.synopsys = synopsys;
        this.releaseDate = releaseDate;
    }

    public Integer getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getSynopsys() {
        return this.synopsys;
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }

    public void edit(Book book) {
        this.title = book.title;
        this.author = book.author;
        this.synopsys = book.synopsys;
        this.releaseDate = book.releaseDate;
    }
}