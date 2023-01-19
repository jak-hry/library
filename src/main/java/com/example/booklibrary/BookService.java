package com.example.booklibrary;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final List<Book> bookList;

    public BookService(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Book> getAllBooks() {
        return bookList;
    }
}
