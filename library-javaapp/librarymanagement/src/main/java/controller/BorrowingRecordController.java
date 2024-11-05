package controller;

package com.example.librarymanagement.controller;

import com.example.librarymanagement.model.BorrowingRecord;
import com.example.librarymanagement.service.BorrowingRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrow")
public class BorrowingRecordController {
    private final BorrowingRecordService borrowingRecordService;

    public BorrowingRecordController(BorrowingRecordService borrowingRecordService) {
        this.borrowingRecordService = borrowingRecordService;
    }

    @GetMapping
    public List<BorrowingRecord> getAllBorrowingRecords() {
        return borrowingRecordService.getAllBorrowingRecords();
    }

    @PostMapping("/{bookId}/patron/{patronId}")
    public BorrowingRecord borrowBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        return borrowingRecordService.borrowBook(bookId, patronId);
    }

    @PutMapping("/return/{bookId}/patron/{patronId}")
    public BorrowingRecord returnBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        return borrowingRecordService.returnBook(bookId, patronId);
    }
}
