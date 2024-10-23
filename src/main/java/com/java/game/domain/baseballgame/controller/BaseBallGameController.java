package com.java.game.domain.baseballgame.controller;

import com.java.game.domain.baseballgame.dto.BaseBallGameInputRequest;
import com.java.game.domain.baseballgame.dto.BaseBallGameResponse;
import com.java.game.domain.baseballgame.dto.BaseBallGameResultResponse;
import com.java.game.domain.baseballgame.service.BaseBallGameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/baseballGame")
public class BaseBallGameController {
    private final BaseBallGameService baseBallGameService;

    public BaseBallGameController(BaseBallGameService baseBallGameService) {
        this.baseBallGameService = baseBallGameService;
    }


    @PostMapping("/{gameId}")
    public ResponseEntity<BaseBallGameResultResponse> startBaseBallGame(
            @PathVariable Long gameId,
            BaseBallGameInputRequest baseBallGameInputRequest){
        return ResponseEntity.ok(baseBallGameService.startGame(gameId,baseBallGameInputRequest));
    }

    @GetMapping()
    public ResponseEntity<BaseBallGameResponse> getBaseBallGameResult() {
        return ResponseEntity.ok(baseBallGameService.makeGame());
    }

}
