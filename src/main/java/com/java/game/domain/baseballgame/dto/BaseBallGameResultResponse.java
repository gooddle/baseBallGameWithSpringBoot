package com.java.game.domain.baseballgame.dto;

import com.java.game.domain.baseballgame.model.BaseBallGame;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Builder
public class BaseBallGameResultResponse {
    private boolean result;
    private int count;
    private int ball;
    private int strike;

    public static BaseBallGameResultResponse from(BaseBallGame baseBallGame,int ball,int strike) {
        return BaseBallGameResultResponse.builder()
                .result(baseBallGame.isResult())
                .count(baseBallGame.getCount())
                .ball(ball)
                .strike(strike)
                .build();
    }
}
