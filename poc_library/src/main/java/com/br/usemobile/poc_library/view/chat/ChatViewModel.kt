package com.br.usemobile.poc_library.view.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.usemobile.poc_library.common.ListenerChat
import com.br.usemobile.poc_library.common.ListenerContato
import com.br.usemobile.poc_library.common.ListenerContato2
import com.br.usemobile.poc_library.data.models.ContactModel
import com.br.usemobile.poc_library.data.service.chat.ChatRealTimeDatabase

internal class ChatViewModel(
    private val chatRealTimeDatabase: ChatRealTimeDatabase
) : ViewModel() {

    private val _conversa: MutableLiveData<ArrayList<String>> =
        MutableLiveData()
    val conversa: LiveData<ArrayList<String>>
        get() = _conversa

    private val _contato: MutableLiveData<String> =
        MutableLiveData()
    val contato: LiveData<String>
        get() = _contato


    private val _addContato: MutableLiveData<String> =
        MutableLiveData()
    val addContato: LiveData<String>
        get() = _addContato


    fun listenerChat(id: String, contato: String) {
        chatRealTimeDatabase.listenerChat(id, contato, object : ListenerChat {
            override fun onReceivedMessage(message: ArrayList<String>) {
                _conversa.postValue(message)
            }
        })
    }

    fun sendMessage(id: String, message: String, contato: String) {
        chatRealTimeDatabase.sendMessage(id, message, contato)
    }

    fun getContato(id: String) {
        chatRealTimeDatabase.getContato(id, object : ListenerContato {
            override fun onSuccess(contato: String) {
                _contato.postValue(contato)
            }

        })

    }

    fun addContact(idEmail: String, contact: String){
        chatRealTimeDatabase.createContact(idEmail, contact, object : ListenerContato {
            override fun onSuccess(contato: String) {
                _addContato.postValue("")
            }
        })
    }


}