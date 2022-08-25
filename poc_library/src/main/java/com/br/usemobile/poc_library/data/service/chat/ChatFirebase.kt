package com.br.usemobile.poc_library.data.service.chat

import com.br.usemobile.poc_library.common.ListenerChat
import com.br.usemobile.poc_library.common.ListenerContato

internal interface ChatFirebase {

    fun listenerChat(id: String, listener: ListenerChat)

    fun sendMessage(id: String, message: String, contato: String)

    fun getContato(id: String, listener: ListenerContato)
}