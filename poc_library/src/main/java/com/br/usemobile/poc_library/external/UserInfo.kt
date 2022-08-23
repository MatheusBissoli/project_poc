package com.br.usemobile.poc_library.external

import java.io.Serializable

data class UserInfo(
    val userCredential: String,
    val userName: String
): Serializable