package com.example.infinitereads.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(allowedHeaders = "*",origins = "*")
@RestController
@RequestMapping(path = "api/v1/book")

public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks(){return bookService.getBooks();}

    @PostMapping
    public void addBook(@RequestBody Book book){
        bookService.addNewBook(book);
    }
    //@CrossOrigin()
    @DeleteMapping(path = "/{bookId}")
    public void deleteBook(@PathVariable("bookId") Long bookId){
        bookService.deleteBook(bookId);
    }

    @PutMapping
    public void updateBook(
            @RequestBody Book book){
        bookService.updateBook(book.getId(),book.getTitle(), book.getAuthor(), book.getIsbn());
    }
}
