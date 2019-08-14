package com.springinaction.spring.exception;

import org.springframework.web.bind.annotation.PutMapping;

//Book not found exception extends the SuperClass of Exception
public class BookNotFoundException extends Exception {
    private long bookId;
    //I am passing the bookid and print the exception in the book id
    public BookNotFoundException(long bookId){
        super(String.format("Book is not found with id :%s", bookId));
    }



}
