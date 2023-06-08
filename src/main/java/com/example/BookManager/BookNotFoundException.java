package com.example.BookManager;

/**
 * @author Amresh Tripathy
 */
public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String str) {
        super(str);
    }
}
