package com.java.game.domain.baseballgame.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "baseballgame")
public class BaseBallGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="result")
    private boolean result;

    @Column(name = "count")
    private int count;

    @Column(name = "answer")
    private String answer;


    
}


