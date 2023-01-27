package com.example.library;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public void addBook(Book book) {
        libraryRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return (List<Book>) libraryRepository.findAll();
    }

    public List<Book> findBookByTitle(Book book) {
        return libraryRepository.findByTitle(book.getTitle());
    }

    public void removeBook(Book book) {
        libraryRepository.delete(book);
    }
}
