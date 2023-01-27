package com.example.library;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
}
