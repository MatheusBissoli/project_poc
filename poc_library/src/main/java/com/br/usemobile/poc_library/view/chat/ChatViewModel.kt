package com.br.usemobile.poc_library.view.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.usemobile.poc_library.common.ListenerChat
import com.br.usemobile.poc_library.common.ListenerContato
import com.br.usemobile.poc_library.data.service.chat.ChatFirebase

internal class ChatViewModel(
    private val chatFirebase: ChatFirebase
) : ViewModel() {

    private val _conversa: MutableLiveData<ArrayList<String>> =
        MutableLiveData()
    val conversa: LiveData<ArrayList<String>>
        get() = _conversa

    private val _contato: MutableLiveData<String> =
        MutableLiveData()
    val contato: LiveData<String>
        get() = _contato


    fun listenerChat(id: String) {
        chatFirebase.listenerChat(id, object : ListenerChat {
            override fun onReceivedMessage(message: ArrayList<String>) {
                _conversa.postValue(message)
            }
        })
    }

    fun sendMessage(id: String, message: String, contato: String) {
        chatFirebase.sendMessage(id, message, contato)
    }

    fun getContato(id: String) {
        chatFirebase.getContato(id, object : ListenerContato {
            override fun onSuccess(contato: String) {
                _contato.postValue(contato)
            }
        })

    }


}