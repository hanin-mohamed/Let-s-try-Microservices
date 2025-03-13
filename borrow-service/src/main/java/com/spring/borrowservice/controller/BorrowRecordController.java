package com.spring.borrowservice.controller;


import com.spring.borrowservice.entity.BorrowRecord;
import com.spring.borrowservice.repository.BorrowRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/borrow")
public class BorrowRecordController {

    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public BorrowRecord borrowBook(@RequestBody BorrowRecord borrowRecord) {
        String bookUrl = "http://book-service:8080/books/" + borrowRecord.getBookId();
        ResponseEntity<Map> bookResponse = restTemplate.getForEntity(bookUrl, Map.class);
        if (bookResponse.getBody() == null || bookResponse.getBody().get("id") == null)
            throw new RuntimeException("Book not found!");

        String userUrl = "http://user-service:8081/users/" + borrowRecord.getUserId();
        ResponseEntity<Map> userResponse = restTemplate.getForEntity(userUrl, Map.class);
        if (userResponse.getBody() == null || userResponse.getBody().get("id") == null)
            throw new RuntimeException("User not found!");


        borrowRecord.setBorrowDate(LocalDateTime.now());
        return borrowRecordRepository.save(borrowRecord);
    }

    @GetMapping
    public List<BorrowRecord> getAllBorrows(){
        return borrowRecordRepository.findAll();
    }
}
