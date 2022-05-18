package com.example.infinitereads.toread;

import com.example.infinitereads.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ToReadRepository extends JpaRepository<ToRead,Long> {

    List<ToRead> findToReadsByUserId(Long userId);
    List<ToRead> findToReadsByUserUsername(String username);
    Optional<ToRead> deleteByUserIdAndBookTitle(Long userId, String title);
}
