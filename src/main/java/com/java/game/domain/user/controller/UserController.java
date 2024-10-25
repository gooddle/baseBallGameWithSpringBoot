package com.java.game.domain.user.controller;

import com.java.game.domain.user.dto.LoginRequest;
import com.java.game.domain.user.dto.LoginResponse;
import com.java.game.domain.user.dto.SignUpRequest;
import com.java.game.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Boolean> signUpUser(SignUpRequest signUpRequest) {
        return ResponseEntity.ok(userService.SignUpUser(signUpRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.LoginUser(loginRequest));
    }
}
