package com.java.game.domain.user.dto

data class SignUpRequest(
    val email: String,
    val password: String,
    val passwordConfirm:String
)
