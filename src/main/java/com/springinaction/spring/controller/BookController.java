package com.springinaction.spring.controller;

import com.springinaction.spring.BookRepo.BookRepo;

import com.springinaction.spring.exception.BookNotFoundException;
import com.springinaction.spring.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

    @Autowired
    BookRepo bookRepo;

    //Get all note
    @GetMapping("/books")
    public List<Book> getUsers(){
        return  bookRepo.findAll();
    }
    //Create a new book
    @PostMapping("/books")
    public Book addUser(@Valid @RequestBody Book book){
      return  bookRepo.save(book);
    }

    //Get a single book
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Long id) throws BookNotFoundException {

        return bookRepo.findById(id)   //Finding a book by id
                .orElseThrow(() -> new BookNotFoundException(id)); //throwing an exception if book not found
    }

    //We are updating and existing book
    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable Long id,@RequestBody Book bookDetails) throws BookNotFoundException {

     Book book = bookRepo.findById(id)
     .orElseThrow(() -> new BookNotFoundException(id));

      book.setBookName(bookDetails.getBookName());
        book.setAuthor(bookDetails.getAuthor());
        book.setIsbn(bookDetails.getIsbn());
        Book updatedBook = bookRepo.save(book);
        return updatedBook;
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id){
        try {
            bookRepo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Book is not found with id :"+ id);
        }
    }
}
