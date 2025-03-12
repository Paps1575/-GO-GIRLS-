package com.uttt.gogirls.domain.model

data class AuthResponse (
    val user: User?=null,
    val token: String?=null
)
