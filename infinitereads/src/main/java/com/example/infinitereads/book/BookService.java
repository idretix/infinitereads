package com.example.infinitereads.book;

import com.example.infinitereads.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public void addNewBook(Book book) {
        Optional<Book> userOptional= bookRepository.findBookByIsbn(book.getIsbn());

        bookRepository.save(book);
        System.out.println(book);
    }

    public void deleteBook(Long bookId) {
        boolean exists = bookRepository.existsById(bookId);
        if(!exists){
            throw new IllegalStateException(
                    "Book with id" + bookId + "does not exist!"
            );
        }
        bookRepository.deleteById(bookId);
    }

    @Transactional
    public void updateBook(Long bookId, String title,String author, String isbn){
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalStateException("User with id " + bookId + "does not exist!"));

        if(title != null && title.length()>0&&!Objects.equals(book.getTitle(),title)){
            book.setTitle(title);
        }
        if(author != null && author.length()>0&&!Objects.equals(book.getAuthor(),author)){
            book.setAuthor(author);
        }
        if(isbn != null && isbn.length()>0&&!Objects.equals(book.getIsbn(),isbn)){
            book.setIsbn(isbn);
        }
    }
}
