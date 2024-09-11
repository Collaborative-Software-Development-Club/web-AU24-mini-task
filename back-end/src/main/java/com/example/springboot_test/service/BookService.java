package com.example.springboot_test.service;

import org.springframework.stereotype.Service;

import com.example.springboot_test.api.model.Book;
import com.example.springboot_test.api.model.BookWithId;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private List<BookWithId> books;

    public BookService() {
        this.books = new ArrayList<>();
        this.fillWithRandomData();
    }

    public Optional<BookWithId> getBook(Integer id) {
        for (BookWithId book : books) {
            if (book.getId() == id) {
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }

    public List<BookWithId> getBooks() {
        return books;
    }

    public BookWithId addBook(Book newBook) {
        BookWithId created = new BookWithId(newBook.getTitle(), newBook.getAuthor(), newBook.getSynopsys(),
                newBook.getReleaseDate());
        books.add(created);
        return created;
    }

    public Optional<BookWithId> editBook(Integer id, Book book) {
        for (BookWithId oldBook : books) {
            if (oldBook.getId() == id) {
                oldBook.edit(book);
                return getBook(id);
            }
        }
        return Optional.empty();
    }

    public Optional<Book> deleteBook(Integer id) {
        Iterator<BookWithId> iter = books.iterator();
        while (iter.hasNext()) {
            BookWithId book = iter.next();
            if (book.getId() == id) {
                iter.remove();
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }

    private void fillWithRandomData() {
        books.add(new BookWithId("To Kill a Mockingbird", "Harper Lee",
                "A young girl named Scout growing up in the racially charged American South learns about justice and compassion.",
                "1960-07-11"));

        books.add(new BookWithId("1984", "George Orwell",
                "A dystopian novel about a totalitarian regime under Big Brother's surveillance and mind control.",
                "1949-06-08"));

        books.add(new BookWithId("Moby-Dick", "Herman Melville",
                "The story of Captain Ahab's obsessive quest to kill the white whale, Moby Dick.",
                "1851-10-18"));

        books.add(new BookWithId("Pride and Prejudice", "Jane Austen",
                "The romantic clash between the opinionated Elizabeth Bennet and the wealthy Mr. Darcy.",
                "1813-01-28"));

        books.add(new BookWithId("The Great Gatsby", "F. Scott Fitzgerald",
                "A story of the mysterious Jay Gatsby and his unrequited love for Daisy Buchanan in the Roaring Twenties.",
                "1925-04-10"));

        books.add(new BookWithId("The Catcher in the Rye", "J.D. Salinger",
                "The experiences of Holden Caulfield, a disillusioned teenager navigating life in New York.",
                "1951-07-16"));

        books.add(new BookWithId("The Hobbit", "J.R.R. Tolkien",
                "Bilbo Baggins embarks on an unexpected journey filled with adventure and peril to recover a stolen treasure.",
                "1937-09-21"));

        books.add(new BookWithId("Harry Potter and the Philosopher's Stone", "J.K. Rowling",
                "An orphaned boy discovers he is a wizard and begins his magical education at Hogwarts.",
                "1997-06-26"));

        books.add(new BookWithId("The Lord of the Rings: The Fellowship of the Ring", "J.R.R. Tolkien",
                "A group of unlikely companions set out to destroy a powerful ring to stop the dark lord Sauron.",
                "1954-07-29"));

        books.add(new BookWithId("The Chronicles of Narnia: The Lion, the Witch and the Wardrobe", "C.S. Lewis",
                "Four siblings discover a magical land where they join the fight to defeat an evil witch.",
                "1950-10-16"));
    }

}