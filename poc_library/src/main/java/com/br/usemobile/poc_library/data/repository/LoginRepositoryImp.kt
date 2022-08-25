package com.br.usemobile.poc_library.data.repository

import com.br.usemobile.poc_library.data.service.FirebaseServiceTestImp
import com.br.usemobile.poc_library.domain.repository.LoginRepository
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

internal class LoginRepositoryImp (
    private val auth: FirebaseServiceTestImp
) : LoginRepository {

    override suspend fun signInWithEmailPassword(
        email: String,
        password: String
    ): Flow<FirebaseUser?> {
        return auth.signInWithEmailPassword(email, password)
    }

    override suspend fun signUpWithEmailPassword(
        email: String,
        password: String
    ): Flow<FirebaseUser?> {
        return auth.signUpWithEmailPassword(email, password)
    }


}