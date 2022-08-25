package com.br.usemobile.poc_library.data.service

import com.br.usemobile.poc_library.common.ListenerFirebase
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

internal interface FirebaseServiceTest {


    suspend fun createUserWithEmailPassword(email:String , password:String, listenerFirebase: ListenerFirebase)

    suspend fun signInWithEmailPassword(email: String , password: String, listenerFirebase: ListenerFirebase)

    fun signOut() : FirebaseUser?

    fun getCurrentUser() : FirebaseUser?

    suspend fun sendResetPassword(email : String) : Boolean
}
