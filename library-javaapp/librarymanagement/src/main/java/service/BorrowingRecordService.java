package service;

package com.example.librarymanagement.service;

import com.example.librarymanagement.model.BorrowingRecord;
import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.model.Patron;
import com.example.librarymanagement.repository.BorrowingRecordRepository;
import com.example.librarymanagement.repository.BookRepository;
import com.example.librarymanagement.repository.PatronRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowingRecordService {
    private final BorrowingRecordRepository borrowingRecordRepository;
    private final BookRepository bookRepository;
    private final PatronRepository patronRepository;

    public BorrowingRecordService(BorrowingRecordRepository borrowingRecordRepository,
                                  BookRepository bookRepository,
                                  PatronRepository patronRepository) {
        this.borrowingRecordRepository = borrowingRecordRepository;
        this.bookRepository = bookRepository;
        this.patronRepository = patronRepository;
    }

    public List<BorrowingRecord> getAllBorrowingRecords() {
        return borrowingRecordRepository.findAll();
    }

    public BorrowingRecord borrowBook(Long bookId, Long patronId) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        Patron patron = patronRepository.findById(patronId).orElseThrow();

        BorrowingRecord record = new BorrowingRecord();
        record.setBook(book);
        record.setPatron(patron);
        record.setBorrowDate(LocalDate.now());

        return borrowingRecordRepository.save(record);
    }

    public BorrowingRecord returnBook(Long bookId, Long patronId) {
        BorrowingRecord record = borrowingRecordRepository.findById(bookId).orElseThrow();
        record.setReturnDate(LocalDate.now());
        return borrowingRecordRepository.save(record);
    }
}
