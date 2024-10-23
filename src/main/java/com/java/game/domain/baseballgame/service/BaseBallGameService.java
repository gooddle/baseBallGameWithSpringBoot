package com.java.game.domain.baseballgame.service;

import com.java.game.domain.baseballgame.dto.BaseBallGameInputRequest;
import com.java.game.domain.baseballgame.dto.BaseBallGameResponse;
import com.java.game.domain.baseballgame.dto.BaseBallGameResultResponse;
import com.java.game.domain.baseballgame.model.BaseBallGame;
import com.java.game.domain.baseballgame.repository.BaseBallGameRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class BaseBallGameService{
    private final BaseBallGameRepository baseBallGameRepository;


    public BaseBallGameResponse makeGame() {
            BaseBallGame newGame = new BaseBallGame();
            newGame.setAnswer(makeAnswer());
            newGame.setCount(0);
            baseBallGameRepository.save(newGame);
            return BaseBallGameResponse.builder().id(newGame.getId()).build();
    }

    @Transactional
    public BaseBallGameResultResponse startGame(Long gameId, BaseBallGameInputRequest baseBallGameInputRequest) {
        BaseBallGame currentGame = baseBallGameRepository.findById(gameId)
                .orElseThrow(() -> new IllegalStateException("게임을 찾을 수 없습니다."));

        currentGame.setCount(currentGame.getCount() + 1);

        currentGame.setResult(Objects.equals(baseBallGameInputRequest.getInputNum(), currentGame.getAnswer()));


        baseBallGameRepository.save(currentGame);
        return BaseBallGameResultResponse.from(currentGame);
    }



    private  String makeAnswer(){
        Random random = new Random();
        HashSet<Integer> results = new LinkedHashSet<>();
        while (results.size() < 3) {
            int num = random.nextInt(10);
            if(results.isEmpty() && num==0){
                continue;
            }
            results.add(num);
        }
        StringBuilder resultString = new StringBuilder();
        for (int num : results) {
            resultString.append(num);
        }
        System.out.println(resultString);

        return resultString.toString();
    }

}

