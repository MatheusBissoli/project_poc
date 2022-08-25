package com.br.usemobile.poc_library.data.service.user

internal interface UserFirebase {

    fun insertUserRealDatabase(uid: String, email: String)

}