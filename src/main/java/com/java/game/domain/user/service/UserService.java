package com.java.game.domain.user.service;


import com.java.game.domain.user.dto.LoginRequest;
import com.java.game.domain.user.dto.LoginResponse;
import com.java.game.domain.user.dto.SignUpRequest;
import com.java.game.domain.user.model.User;
import com.java.game.domain.user.repository.UserRepository;
import com.java.game.infra.security.jwt.JwtPlugin;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtPlugin jwtPlugin;

    @Transactional
    public Boolean SignUpUser(SignUpRequest signUpRequest){
        if(userRepository.existsByEmail(signUpRequest.getEmail())){
            throw new IllegalArgumentException("Username is already in use");
        }
        if(!signUpRequest.getPassword().equals(signUpRequest.getPasswordConfirm())){
            throw new IllegalArgumentException("Passwords do not match");
        }
        User user = new User();

        user.setEmail(signUpRequest.getEmail());
        user.setRole("ROLE_USER");
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        userRepository.save(user);
        return true;
    }


    public LoginResponse LoginUser(LoginRequest loginRequest){
        User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(()-> new IllegalArgumentException("Invalid username or password"));
        if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
            throw new IllegalArgumentException("Invalid password");
        }
        String token = jwtPlugin.generateAccessToken(
                String.valueOf(user.getId()), // subject (유저 ID)
                user.getRole(),          // role (유저 역할)
                user.getEmail()       // username (유저 이름)
        );
        return new LoginResponse(token);
    }
}
