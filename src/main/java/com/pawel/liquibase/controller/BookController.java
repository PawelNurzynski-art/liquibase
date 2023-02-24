package com.pawel.liquibase.controller;

import com.pawel.liquibase.dto.BookDto;
import com.pawel.liquibase.entity.BookEntity;
import com.pawel.liquibase.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

    public BookRepository bookRepository;
    public BookDto bookDto = new BookDto();

    // get all books
    @GetMapping("")
    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    // get book by ID
    @GetMapping("/{id}")
    public Optional<BookEntity> getBook(@PathVariable("id") UUID id) {
        return bookRepository.findById(id);
    }

    // add book
    @PostMapping("")
    public BookEntity addBook(@RequestBody BookDto bookDto) {
        BookEntity newBook = new BookEntity();

        newBook.setTitle(bookDto.getTitle());
        newBook.setAuthor(bookDto.getAuthor());
        newBook.setPagesNumber(bookDto.getPagesNumber());
        newBook.setReleaseYear(bookDto.getReleaseYear());
        newBook.setCoverType(bookDto.getCoverType());

        bookRepository.save(newBook);
        return newBook;
    }

    // edit book
    @PutMapping("/{id}")
    public BookEntity editBook(@PathVariable("id") UUID id,
                         @RequestBody BookDto bookDto) {

        BookEntity editedBook = bookRepository.getById(id);

        editedBook.setTitle(bookDto.getTitle());
        editedBook.setAuthor(bookDto.getAuthor());
        editedBook.setPagesNumber(bookDto.getPagesNumber());
        editedBook.setReleaseYear(bookDto.getReleaseYear());
        editedBook.setCoverType(bookDto.getCoverType());

        bookRepository.save(editedBook);
        return editedBook;
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") UUID id) {
        bookRepository.deleteById(id);
    }
}
