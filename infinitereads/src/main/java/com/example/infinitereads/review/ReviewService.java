package com.example.infinitereads.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository){this.reviewRepository=reviewRepository;}

    public List<Review> getReviews(){
        return reviewRepository.findAll();
    }
    public List<Review> getReviewsByBookReviewedId(Long bookId){
        return reviewRepository.findReviewsByBookReviewedId(bookId);
    }
    public List<Review> getReviewsByUserAuthorId(Long userId){
        return reviewRepository.findReviewsByUserAuthorId(userId);
    }
    public List<Review> getReviewsByUserAuthorIdAndBookReviewedId(Long userId, Long bookId){
        return reviewRepository.findReviewsByUserAuthorIdAndBookReviewedId(userId,bookId);
    }
    public List<Review> getReviewsByBookReviewedTitle(String title){
        return reviewRepository.findReviewsByBookReviewedTitle(title);
    }
    public List<Review> getReviewsByUserAuthorUsername(String username){
        return reviewRepository.findReviewsByUserAuthorUsername(username);
    }

    public void addNewReview(Review review){
        reviewRepository.save(review);
    }
    public void deleteReview(Long id){
        boolean exists = reviewRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Review with id" + id + "does not exist!");
        }
        reviewRepository.deleteById(id);
    }
    @Transactional
    public void updateReview(Long id,String text,Float rating){
        Review review = reviewRepository.findById(id).orElseThrow(() -> new IllegalStateException("Review with id" + id + "does not exist!"));

        review.setText(text);
        if(rating != null &&!Objects.equals(review.getRating(),rating)){
            review.setRating(rating);
        }
    }
}
