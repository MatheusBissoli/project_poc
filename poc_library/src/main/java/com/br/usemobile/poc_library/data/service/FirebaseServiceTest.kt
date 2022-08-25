package com.br.usemobile.poc_library.data.service

import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class FirebaseServiceTestImp : FirebaseServiceTest {
    val auth = FirebaseAuth.getInstance(FirebaseApp.getInstance())

    override suspend fun signInWithEmailPassword(
        email: String,
        password: String
    ): Flow<FirebaseUser?> =
        flow {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        task.result
                    } else {
                        throw Exception(task.exception)
                    }
                }.let {
                    emit(
                        value = it.result?.user
                    )
                }
        }

    override suspend fun signUpWithEmailPassword(
        email: String,
        password: String
    ): Flow<FirebaseUser?> =
        flow {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        task.result
                    } else {
                        throw Exception(task.exception)
                    }
                }.let {
                    emit(
                        value = it.result?.user
                    )
                }
        }


    override fun signOut(): FirebaseUser? {
        TODO("Not yet implemented")
    }

    override fun getCurrentUser(): FirebaseUser? {
        TODO("Not yet implemented")
    }

    override suspend fun sendResetPassword(email: String): Boolean {
        TODO("Not yet implemented")
    }
}