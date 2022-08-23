package com.br.usemobile.poc_library.common

import java.io.Serializable

data class UserInfo(
    val userCredential: String,
    val userName: String
): Serializable