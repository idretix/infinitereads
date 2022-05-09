package com.example.infinitereads.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(allowedHeaders = "*",origins = "*")
@RestController
@RequestMapping(path = "api/v1/review")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @GetMapping
    public List<Review> getReviews(){return reviewService.getReviews();}
    @GetMapping(path="/bookid/{bookId}")
    public List<Review> getReviewsByBookId(@PathVariable("bookId")Long bookId){
        return reviewService.getReviewsByBookReviewedId(bookId);
    }
    @GetMapping(path="/userid/{userId}")
    public List<Review> getReviewsByUserId(@PathVariable("userId")Long userId){
        return reviewService.getReviewsByUserAuthorId(userId);
    }
    @GetMapping(path="/{userId}/{bookId}")
    public List<Review> getReviewsByUserId(@PathVariable("userId")Long userId,@PathVariable("bookId")Long bookId){
        return reviewService.getReviewsByUserAuthorIdAndBookReviewedId(userId,bookId);
    }
    @PostMapping
    public void writeNewReview(@RequestBody Review review){reviewService.addNewReview(review);}

    @DeleteMapping(path = "/{id}")
    public void deleteReview(@PathVariable("id") Long id){
        reviewService.deleteReview(id);
    }

    @PutMapping
    public void updateReview(
            @RequestBody Review review
    ){
        reviewService.updateReview(review.getId(),review.getText(),review.getRating());
    }
}
