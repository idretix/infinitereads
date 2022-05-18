package com.example.infinitereads.top;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopRepository extends JpaRepository<Top,Long> {
    List<Top> findTopsByUserAuthorId(Long userId);
    List<Top> findTopsByUserAuthorUsername(String username);
    Optional<Top> deleteByTierAndUserAuthorId(Integer tier,Long userId);
}
