package com.example.BookManager;

import java.util.List;
import java.util.Optional;

/**
 * @author Amresh Tripathy
 */
public class BookService {
    private BookRepository bookRepository = new BookRepository();

    public String addBook(Book book) {
        bookRepository.add(book);
        return "book added with id: " + book.getId();
    }

    public Book getBook(Integer id) throws BookNotFoundException {
        Optional<Book> bookOptional = bookRepository.getById(id);
        if (bookOptional.isEmpty()) {
            throw new BookNotFoundException("book id not found");
        }
        return bookOptional.get();
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAll();
    }

    public Book getBook(String name) throws BookNotFoundException {
        List<Book> books = bookRepository.getAll();
        for (Book book : books) {
            if (book.getTitle().equals(name))
                return book;
        }
        throw new BookNotFoundException("Book name invalid");
    }

    public Book updateBookPages(Integer id, Integer pages) throws BookNotFoundException {
        Book book = getBook(id);
        book.setPages(pages);
        bookRepository.update(book);
        return book;
    }

    public void removeBookById(Integer id) {
        bookRepository.delete(id);
    }
}
