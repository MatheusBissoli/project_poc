package com.br.usemobile.poc_library.domain.repository

import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

internal interface LoginRepository {

    suspend fun signInWithEmailPassword(email:String , password:String): Flow<FirebaseUser?>

    suspend fun signUpWithEmailPassword(email: String , password: String): Flow<FirebaseUser?>

}