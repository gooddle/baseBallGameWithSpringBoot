package com.java.game.domain.user.repository;

import com.java.game.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByEmail(String username);
    Optional<User> findByEmail(String username);
}
