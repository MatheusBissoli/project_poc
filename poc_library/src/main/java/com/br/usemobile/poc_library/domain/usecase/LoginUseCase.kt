package com.br.usemobile.poc_library.domain.usecase

import com.br.usemobile.poc_library.common.ListenerFirebase
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

internal interface LoginUseCase {

    suspend fun signInWithEmailPassword(email:String , password:String,  listener: ListenerFirebase)

    suspend fun createUserWithEmailPassword(email: String , password: String,  listener: ListenerFirebase)
}