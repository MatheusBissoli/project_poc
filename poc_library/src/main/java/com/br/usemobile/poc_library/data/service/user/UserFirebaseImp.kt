package com.br.usemobile.poc_library.data.service.user

import com.google.firebase.database.FirebaseDatabase

internal class UserFirebaseImp: UserFirebase {

    val database: FirebaseDatabase = FirebaseDatabase.getInstance()

    override fun insertUserRealDatabase(uid: String, email: String) {
       database.reference.child("users").child(uid).child("email").setValue(email)
    }

}