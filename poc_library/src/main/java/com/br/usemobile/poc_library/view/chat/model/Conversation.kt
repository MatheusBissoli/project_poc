package com.br.usemobile.poc_library.view.chat.model

internal data class Conversation(
    val id: String,
    val senderName: String,
    val timeLastMessage: String,
    val lastMessage: String
)