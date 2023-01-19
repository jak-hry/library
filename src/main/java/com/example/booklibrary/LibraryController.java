package com.example.booklibrary;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/library")
public class LibraryController {

    private final BookService bookService;

    public LibraryController(BookService bookRepository) {
        this.bookService = bookRepository;
    }

    @GetMapping("/list")
    public List<Book> getBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/list/string")
    public String getBooksSpring() {

        List<Book> booksList = bookService.getAllBooks();
        if (booksList.size() == 0) {
            return "book library is empty";
        } else {
            return booksList.stream()
                    .map(book -> book.toString().replace(",", ""))
                    .collect(Collectors.joining());
        }
    }

    @PostMapping("/add")
    public String addBook(@RequestBody Book addingBook) {

        for (Book book : bookService.getAllBooks()) {
            if (book.getTitle().equals(addingBook.getTitle())) {
                return "book with title: " + addingBook.getTitle() + " is already added";
            }
        }
        bookService.getAllBooks().add(addingBook);
        return "book with title: " + addingBook.getTitle() + " added";
    }

    @PutMapping("/update/{id}")
    public String updateBook(@PathVariable("id") int id, @RequestBody Book updatedBook) {

        List<Book> list = bookService.getAllBooks();

        if (id > list.size() || list.size() == 0) {
            return "there is no book with id: " + id;
        } else if (id < list.size()){
            list.get(id).setTitle(updatedBook.getTitle());
            list.get(id).setProductionYear(updatedBook.getProductionYear());
            list.get(id).setRating(updatedBook.getRating());
            return "book with title: " + updatedBook.getTitle() + " updated";
        } else {
            return "there is no such book";
        }
    }

    @DeleteMapping("/remove")
    public String removeBook(@RequestBody Book book) {

        if (bookService.getAllBooks().contains(book)) {
            bookService.getAllBooks().remove(book);
            return "book removed";
        } else {
            return "there is no such book";
        }
    }
}
