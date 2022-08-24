package com.br.usemobile.poc_library.data.service

import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

internal interface FirebaseServiceTest {


    suspend fun signInWithEmailPassword(email:String , password:String): Flow<FirebaseUser?>

    suspend fun signUpWithEmailPassword(email: String , password: String): Flow<FirebaseUser?>

    fun signOut() : FirebaseUser?

    fun getCurrentUser() : FirebaseUser?

    suspend fun sendResetPassword(email : String) : Boolean
}
