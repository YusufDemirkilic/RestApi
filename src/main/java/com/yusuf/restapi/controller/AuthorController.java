package com.yusuf.restapi.controller;

import com.yusuf.restapi.customExeption.NotFoundException;
import com.yusuf.restapi.entities.Author;
import com.yusuf.restapi.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Author> gettAllAuthor() {
        return this.authorService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author getAuthorById(@PathVariable Long id) {
        return this.authorService.findById(id);
    }

    @PostMapping //Yazar ekleme
    @ResponseStatus(HttpStatus.CREATED)
    public Author save(@RequestBody Author author) {
        return this.authorService.save(author);
    }

    @PutMapping("/{id}") //Yazar Güncelleme
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        try {
            Author updateAuthor = this.authorService.update(id, author);
            return ResponseEntity.ok(updateAuthor);

        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(author);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteById(id);

    }
}
