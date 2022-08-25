package com.br.usemobile.poc_library.domain.usecase

import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

internal interface LoginUseCase {

    suspend fun signInWithEmailPassword(email:String , password:String): Flow<FirebaseUser?>

    suspend fun signUpWithEmailPassword(email: String , password: String): Flow<FirebaseUser?>
}