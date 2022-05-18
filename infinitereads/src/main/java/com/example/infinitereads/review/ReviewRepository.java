package com.example.infinitereads.review;

import com.example.infinitereads.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

    List<Review> findReviewsByBookReviewedId(Long bookId);
    List<Review> findReviewsByUserAuthorId(Long userId);
    List<Review> findReviewsByUserAuthorIdAndBookReviewedId(Long userId, Long bookId);
    List<Review> findReviewsByBookReviewedTitle(String title);
    List<Review> findReviewsByUserAuthorUsername(String username);
    Double findAverageRatingByBookReviewedId(Long bookId);
}
