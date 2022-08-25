package com.br.usemobile.poc_library.domain.usecase

import com.br.usemobile.poc_library.common.ListenerFirebase
import com.br.usemobile.poc_library.domain.repository.LoginRepository
import com.google.firebase.auth.FirebaseUser

internal class LoginUseCaseImp(
    private val loginRepository: LoginRepository
) : LoginUseCase {
    override suspend fun signInWithEmailPassword(
        email: String,
        password: String,
        listener: ListenerFirebase
    ) {
        loginRepository.signInWithEmailPassword(email, password, object : ListenerFirebase {
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
        loginRepository.createUserWithEmailPassword(email, password, object : ListenerFirebase {
            override fun onSuccess(user: FirebaseUser) {
                listener.onSuccess(user)
            }

            override fun onError(e: Throwable) {
                listener.onError(e)
            }
        })
    }

}