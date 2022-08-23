package com.br.usemobile.poc_library.view.model

sealed class ItemChat {

    data class User(
        val message: String,
        val time: String
    ) : ItemChat()

    data class Sender(
        val message: String,
        val time: String
    ) : ItemChat()
}