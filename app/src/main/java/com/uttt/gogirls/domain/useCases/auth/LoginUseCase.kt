package com.uttt.gogirls.domain.useCases.auth

import com.uttt.gogirls.domain.repository.AuthRepository

class LoginUseCase (private val repository:AuthRepository) {
    suspend operator fun invoke(email:String,password:String)=repository.login(email, password)
}