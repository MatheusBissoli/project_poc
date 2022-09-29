package com.br.usemobile.poc_library.data.service.chat

import com.br.usemobile.poc_library.common.ListenerChat
import com.br.usemobile.poc_library.common.ListenerContato
import com.br.usemobile.poc_library.common.ListenerContato2

internal interface ChatRealTimeDatabase {

    fun listenerChat(id: String,  contato: String, listener: ListenerChat)

    fun sendMessage(id: String, message: String, contato: String)

    fun getContato(id: String, listener: ListenerContato)

    fun createContact(id: String, contact: String, listener: ListenerContato)

    fun createProfileRealDataTime( email: String)
}