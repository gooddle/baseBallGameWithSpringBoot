package com.java.game.domain.baseballgame.repository;

import com.java.game.domain.baseballgame.model.BaseBallGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseBallGameRepository extends JpaRepository<BaseBallGame, Long> {
}
