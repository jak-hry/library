package com.example.library;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/library")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService bookRepository) {
        this.libraryService = bookRepository;
    }

    @GetMapping("/list")
    public List<Book> getBooks(){
        return libraryService.getAllBooks();
    }

    @GetMapping("/list/string")
    public String getBooksSpring() {

        List<Book> booksList = libraryService.getAllBooks();
        if (booksList.size() == 0) {
            return "book library is empty";
        } else {
            return booksList.stream()
                    .map(book -> book.toString().replace(",", ""))
                    .collect(Collectors.joining());
        }
    }

    @GetMapping("/{title}")
    public List<Book> getBookByTitle(Book book){
        return libraryService.findBookByTitle(book);
    }

    @PostMapping
    public String addBook(@RequestBody Book addingBook) {

        for (Book book : libraryService.getAllBooks()) {
            if (book.getTitle().equals(addingBook.getTitle())) {
                return "book with title: " + addingBook.getTitle() + " is already added";
            }
        }
        libraryService.addBook(addingBook);
        return "book with title: " + addingBook.getTitle() + " added";
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable("id") int id, @RequestBody Book updatedBook) {

        List<Book> list = libraryService.getAllBooks();

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

    @DeleteMapping
    public String removeBook(@RequestBody Book book) {

        if (libraryService.getAllBooks().contains(book)) {
            libraryService.removeBook(book);
            return "book removed";
        } else {
            return "there is no such book";
        }
    }
}
