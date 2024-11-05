package model;
package com.example.librarymanagement.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Data;

@Entity
@Data
public class BorrowingRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Book book;

    @ManyToOne
    private Patron patron;

    private LocalDate borrowDate;
    private LocalDate returnDate;
}

