package com.cibefit.backend.dtos

data class RegisterRequest(
    val username: String,
    val email: String,
    val password: String,
    val altura: Int,
    val peso: Double,
    val rol: String
)