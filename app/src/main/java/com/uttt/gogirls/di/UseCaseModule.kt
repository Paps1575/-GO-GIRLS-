package com.uttt.gogirls.di

import com.uttt.gogirls.domain.repository.AuthRepository
import com.uttt.gogirls.domain.useCases.auth.AuthUseCase
import com.uttt.gogirls.domain.useCases.auth.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository)=AuthUseCase(
        login = LoginUseCase(authRepository)
    )
}