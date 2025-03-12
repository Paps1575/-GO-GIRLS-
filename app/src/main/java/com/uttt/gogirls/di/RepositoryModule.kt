package com.uttt.gogirls.di

import com.uttt.gogirls.data.dataSource.remote.service.AuthService
import com.uttt.gogirls.data.repository.AuthRepositoryImpl
import com.uttt.gogirls.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAuthRepository(authService: AuthService):AuthRepository=AuthRepositoryImpl(authService)
}