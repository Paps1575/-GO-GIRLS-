package com.uttt.gogirls.domain.repository

import com.uttt.gogirls.domain.model.AuthResponse
import com.uttt.gogirls.domain.model.util.Resource

interface AuthRepository {
    suspend fun login(email:String,password:String):Resource<AuthResponse>
}