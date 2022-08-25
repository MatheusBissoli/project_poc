package com.br.usemobile.poc_library.domain.usecase.login

import com.br.usemobile.poc_library.common.ListenerFirebase

internal interface LoginUseCase {

    suspend fun signInWithEmailPassword(email:String , password:String,  listener: ListenerFirebase)

    suspend fun createUserWithEmailPassword(email: String , password: String,  listener: ListenerFirebase)
}