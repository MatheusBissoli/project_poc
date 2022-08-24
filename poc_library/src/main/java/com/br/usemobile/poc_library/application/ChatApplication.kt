package com.br.usemobile.poc_library.application

import android.app.Application
import com.google.firebase.FirebaseApp


internal class ChatApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}