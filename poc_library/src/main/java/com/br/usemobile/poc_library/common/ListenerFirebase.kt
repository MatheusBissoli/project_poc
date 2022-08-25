package com.br.usemobile.poc_library.common

import com.google.firebase.auth.FirebaseUser

internal interface ListenerFirebase {

    fun onSuccess(user: FirebaseUser)

    fun onError(e: Throwable)
}