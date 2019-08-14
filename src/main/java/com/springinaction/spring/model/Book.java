package com.springinaction.spring.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name="Book")
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private   String bookName;
    @NotBlank
    private  String author;
    @NotBlank
    private   String isbn;


    public Book(Long id, String bookName, String author, String isbn) {

        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.isbn = isbn;
    }

    public Book(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
