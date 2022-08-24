package com.br.usemobile.poc_library.domain.usecase

import com.br.usemobile.poc_library.domain.repository.LoginRepository
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

internal class LoginUseCaseImp(
    private val loginRepository: LoginRepository
) : LoginUseCase {
    override suspend fun signInWithEmailPassword(
        email: String,
        password: String
    ): Flow<FirebaseUser?> {
        return loginRepository.signInWithEmailPassword(email, password)
    }

    override suspend fun signUpWithEmailPassword(
        email: String,
        password: String
    ): Flow<FirebaseUser?> {
        return loginRepository.signUpWithEmailPassword(email, password)
    }

}