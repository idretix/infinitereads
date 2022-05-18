package com.example.infinitereads.toread;

import com.example.infinitereads.book.Book;
import com.example.infinitereads.user.Users;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class ToRead {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long id;
  /*  private Long userId;
    private Long bookId;*/
    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private Users user;
    @OneToOne
    @JoinColumn(name = "bookId", referencedColumnName = "id")
    private Book book;

    public ToRead() {
    }

    public ToRead(Long id, Users user, Book book) {
        this.id = id;
        this.user = user;
        this.book = book;
    }

    public ToRead(Users user, Book book) {
        this.user = user;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
