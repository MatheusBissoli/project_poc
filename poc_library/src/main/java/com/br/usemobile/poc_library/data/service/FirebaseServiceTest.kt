package com.br.usemobile.poc_library.data.service

import com.br.usemobile.poc_library.common.ListenerFirebase
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

internal class FirebaseServiceTestImp : FirebaseServiceTest {
    val auth = FirebaseAuth.getInstance(FirebaseApp.getInstance())

    override suspend fun createUserWithEmailPassword(
        email: String,
        password: String,
        listenerFirebase: ListenerFirebase
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    task.result?.user?.let { it -> listenerFirebase.onSuccess(it) }
                } else if (!task.isCanceled) {
                    task.exception?.let { listenerFirebase.onError(it) }
                }
            }
    }


    override suspend fun signInWithEmailPassword(
        email: String,
        password: String,
        listenerFirebase: ListenerFirebase
    ) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->

                if (task.isSuccessful) {
                    task.result?.user?.let { it -> listenerFirebase.onSuccess(it) }
                } else if (!task.isCanceled) {
                    task.exception?.let { listenerFirebase.onError(it) }
                }
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