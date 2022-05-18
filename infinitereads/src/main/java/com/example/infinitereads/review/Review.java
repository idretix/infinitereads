package com.example.infinitereads.review;

import com.example.infinitereads.book.Book;
import com.example.infinitereads.user.Users;

import javax.persistence.*;

@Entity
@Table
public class Review {
    @Id
    @SequenceGenerator(name ="user_sequence",sequenceName="user_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_sequence")
    private Long id;
  /*  private Long userId;
    private Long bookId;*/

    float rating;
    String text;

    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private Users userAuthor;
    @OneToOne
    @JoinColumn(name = "bookId", referencedColumnName = "id")
    private Book bookReviewed;

    public Review() {
    }

    public Review(Long id, float rating, String text, Users userAuthor, Book bookReviewed) {
        this.id = id;
        this.rating = rating;
        this.text = text;
        this.userAuthor = userAuthor;
        this.bookReviewed = bookReviewed;
    }

    public Review(float rating, String text, Users userAuthor, Book bookReviewed) {
        this.rating = rating;
        this.text = text;
        this.userAuthor = userAuthor;
        this.bookReviewed = bookReviewed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Users getUserAuthor() {
        return userAuthor;
    }

    public void setUserAuthor(Users userAuthor) {
        this.userAuthor = userAuthor;
    }

    public Book getBookReviewed() {
        return bookReviewed;
    }

    public void setBookReviewed(Book bookReviewed) {
        this.bookReviewed = bookReviewed;
    }
}
