package com.indianhive.web.User.repository;


import com.indianhive.web.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  // Finds a User by email (used for login)
  // SELECT * FROM users WHERE email = ?
  Optional<User> findByEmail(String email);
}