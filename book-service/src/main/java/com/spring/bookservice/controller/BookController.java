package com.spring.bookservice.controller;

import com.spring.bookservice.entity.BookEntity;
import com.spring.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @GetMapping("/{id}")
    public BookEntity getBook(@PathVariable int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<BookEntity> getBooks() {
        return bookRepository.findAll();
    }

    @PostMapping
    public BookEntity addBook(@RequestBody BookEntity book) {
        return bookRepository.save(book);
    }
}
