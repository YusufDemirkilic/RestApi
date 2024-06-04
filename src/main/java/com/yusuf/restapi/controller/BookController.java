package com.yusuf.restapi.controller;

import com.yusuf.restapi.entities.Book;
import com.yusuf.restapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping     //Kitap listeleme
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBook() {
        return bookService.findAll();
    }

    @PostMapping    //Kitap ekleme
    @ResponseStatus(HttpStatus.CREATED)
    public Book save(@RequestBody Book book) {
        return bookService.save(book);
    }

    // Mevcut bir kitabı güncellemek için kullanılan endpoint
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateCustomer(@PathVariable Long id, @RequestBody Book book) {
        Optional<Book> existingBook = Optional.ofNullable(bookService.findById(id));
        if (existingBook.isPresent()) {
            book.setId(id);
            Book updatedCustomer = bookService.save(book);
            return ResponseEntity.ok(updatedCustomer);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }



    @GetMapping("/{id}")  //id'ye göre kitap çekme
    @ResponseStatus(HttpStatus.OK)
    private Book getBookById(@PathVariable Long id)
    {
        return bookService.findById(id);

    }

    @DeleteMapping("/{id}") //Kitap silme
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable Long id)
    {
       bookService.deleteById(id);

    }


}
