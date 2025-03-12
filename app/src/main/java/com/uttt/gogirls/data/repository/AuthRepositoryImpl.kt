package com.uttt.gogirls.data.repository

import android.util.Log
import com.uttt.gogirls.data.dataSource.remote.service.AuthService
import com.uttt.gogirls.domain.model.AuthResponse
import com.uttt.gogirls.domain.model.util.Resource
import com.uttt.gogirls.domain.repository.AuthRepository

class AuthRepositoryImpl(private val authService: AuthService):AuthRepository {
    override suspend fun login(email: String, password: String): Resource<AuthResponse> {
        return try {
            val result=authService.login(email,password)
            if (result.isSuccessful){
                Log.d("AuthRepositoryImpl","${result.body()}")
                Resource.Succes(result.body()!!)
            }else{
                Log.d("AuthRepositoryImpl","Error en la peticion")

                Resource.Failure("Error em la peticion")


            }

        }catch (e:Exception){
            Log.d("AuthRepositoryImpl","Message:${e}")
            Log.d("AuthRepositoryImpl","Message Cause:${e.cause}")
            e.printStackTrace()
            Resource.Failure(e.message?:"Error desconocido")

        }
    }
}