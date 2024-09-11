package com.example.springboot_test.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.springboot_test.api.model.Book;
import com.example.springboot_test.api.model.BookWithId;
import com.example.springboot_test.service.BookService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookWithId> getBook(@PathVariable String id) {
        int idAsNumber = Integer.parseInt(id);
        Optional<BookWithId> book = bookService.getBook(idAsNumber);
        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookWithId>> getBooks() {
        return ResponseEntity.ok(bookService.getBooks());
    }

    @PostMapping("/books")
    public ResponseEntity<BookWithId> addBook(@RequestBody Book newBook) {
        BookWithId created = bookService.addBook(newBook);
        return ResponseEntity.ok(created);

    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> editBook(@PathVariable String id, @RequestBody Book book) {
        System.out.println("In put method");
        int idAsNumber = Integer.parseInt(id);
        Optional<BookWithId> newBook = bookService.editBook(idAsNumber, book);
        System.out.println(newBook);
        if (newBook.isPresent()) {
            return ResponseEntity.ok(newBook.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable String id) {
        int idAsNumber = Integer.parseInt(id);
        Optional<Book> deleted = bookService.deleteBook(idAsNumber);
        if (deleted.isPresent()) {
            return ResponseEntity.ok(deleted.get());
        }
        return ResponseEntity.notFound().build();
    }
}
