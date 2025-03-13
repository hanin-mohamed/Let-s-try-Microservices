package com.spring.bookservice.controller;

import com.spring.bookservice.entity.Book;
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
    public Book getBook(@PathVariable int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }
}
