package com.example.infinitereads.top;

import com.example.infinitereads.book.Book;
import com.example.infinitereads.user.Users;

import javax.persistence.*;

@Entity
@Table
public class Top {
    @Id
    @SequenceGenerator(name ="user_sequence",sequenceName="user_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_sequence")
    private Long id;
    private Integer tier;

    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private Users userAuthor;
    @OneToOne
    @JoinColumn(name = "bookId", referencedColumnName = "id")
    private Book book;

    public Top() {
    }

    public Top(Long id, Integer tier, Users userAuthor, Book book) {
        this.id = id;
        this.tier = tier;
        this.userAuthor = userAuthor;
        this.book = book;
    }

    public Top(Integer tier, Users userAuthor, Book book) {
        this.tier = tier;
        this.userAuthor = userAuthor;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTier() {
        return tier;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }

    public Users getUserAuthor() {
        return userAuthor;
    }

    public void setUserAuthor(Users userAuthor) {
        this.userAuthor = userAuthor;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
