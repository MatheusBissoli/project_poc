package com.br.usemobile.poc_library.domain.repository

import com.br.usemobile.poc_library.common.ListenerFirebase

internal interface LoginRepository {

    suspend fun signInWithEmailPassword(email:String , password:String ,  listener: ListenerFirebase)

    suspend fun createUserWithEmailPassword(email: String , password: String,    listener: ListenerFirebase)

}