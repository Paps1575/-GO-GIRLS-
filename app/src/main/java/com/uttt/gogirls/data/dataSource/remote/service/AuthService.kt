package com.uttt.gogirls.data.dataSource.remote.service

import com.uttt.gogirls.domain.model.AuthResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthService {
    @FormUrlEncoded
    @POST("auth/login")
    suspend fun  login(
        @Field("email") email:String,
        @Field("password") password:String,
    ):Response<AuthResponse>
}