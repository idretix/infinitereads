package com.example.infinitereads.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.OptionalInt;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

    Optional<Users> findUserById(Long id);
    Optional<Users> findUserByEmail(String email);
    Optional<Users> findUserByUsernameAndPassword(String username, String password);
}
