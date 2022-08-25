package com.br.usemobile.poc_library.data.repository

import com.br.usemobile.poc_library.common.ListenerFirebase
import com.br.usemobile.poc_library.data.service.FirebaseServiceTestImp
import com.br.usemobile.poc_library.domain.repository.LoginRepository
import com.google.firebase.auth.FirebaseUser

internal class LoginRepositoryImp(
    private val auth: FirebaseServiceTestImp
) : LoginRepository {

    override suspend fun signInWithEmailPassword(
        email: String,
        password: String,
        listener: ListenerFirebase
    ) {
        return auth.signInWithEmailPassword(email, password, object : ListenerFirebase {
            override fun onSuccess(user: FirebaseUser) {
                listener.onSuccess(user)
            }

            override fun onError(e: Throwable) {
                listener.onError(e)
            }
        })
    }

    override suspend fun createUserWithEmailPassword(
        email: String,
        password: String,
        listener: ListenerFirebase
    ) {
        auth.createUserWithEmailPassword(email, password, object : ListenerFirebase {
            override fun onSuccess(user: FirebaseUser) {
                listener.onSuccess(user)
            }

            override fun onError(e: Throwable) {
                listener.onError(e)
            }
        })
    }


}