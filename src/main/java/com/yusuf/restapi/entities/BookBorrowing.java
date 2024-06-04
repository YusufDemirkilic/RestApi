package com.yusuf.restapi.entities;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "book_borrowings")
public class BookBorrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String borrowerName;
    private String borrowerEmail;
    private LocalDate borrowingDate;
    private LocalDate returnDate;


    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;


}
