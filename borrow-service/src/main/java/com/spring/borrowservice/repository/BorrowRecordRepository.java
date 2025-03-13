package com.spring.borrowservice.repository;

import  com.spring.borrowservice.entity.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Integer> {

}
