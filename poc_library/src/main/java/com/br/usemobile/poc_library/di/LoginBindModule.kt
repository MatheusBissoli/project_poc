package com.br.usemobile.poc_library.di

import com.br.usemobile.poc_library.data.repository.LoginRepositoryImp
import com.br.usemobile.poc_library.domain.repository.LoginRepository
import com.br.usemobile.poc_library.domain.usecase.LoginUseCase
import com.br.usemobile.poc_library.domain.usecase.LoginUseCaseImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface LoginBindModule {

    @Binds
    fun bindLoginUseCase(imp: LoginUseCaseImp): LoginUseCase

    @Binds
    fun bindLoginRepository(imp: LoginRepositoryImp): LoginRepository
}