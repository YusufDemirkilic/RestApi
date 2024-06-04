package com.yusuf.restapi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue  (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50,nullable = false)
    private String name;

    private int publicationYear;
    private int stock;


    @ManyToOne()
    @JoinColumn(name = "author_id")
    private Author author;

    // JPA, Book tablosundaki publisher_id sütununu Publisher tablosundaki id ile otomatik olarak eşleştiriyor.
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;


    @ManyToMany(mappedBy = "bookList")
    private List<Category> categoryList;


    @OneToMany(mappedBy = "book")
    private List<BookBorrowing>bookBorrowings = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
