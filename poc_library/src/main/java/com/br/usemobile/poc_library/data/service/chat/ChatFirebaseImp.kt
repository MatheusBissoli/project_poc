package com.br.usemobile.poc_library.data.service.chat

import com.br.usemobile.poc_library.common.ListenerChat
import com.br.usemobile.poc_library.common.ListenerContato
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

internal class ChatFirebaseImp : ChatFirebase {

    val database: FirebaseDatabase = FirebaseDatabase.getInstance()

    override fun listenerChat(id: String, listener: ListenerChat) {
        database.getReference("users").child(id).child("1").addValueEventListener(object :
            ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                val list = arrayListOf<String>()
                for (post in snapshot.children) {
                    list.add(post.value.toString())
                }
                listener.onReceivedMessage(list)

            }

            override fun onCancelled(error: DatabaseError) {
                // listener.error(error.message)
            }

        })
    }

    override fun sendMessage(id: String, message: String, contato: String) {
        database.getReference("users").child(id).child("1").push().setValue(message)
        database.getReference("users").child(contato).child("1").push().setValue(message)
    }

    override fun getContato(id: String, listener: ListenerContato) {
        database.getReference("users").child(id).get().addOnSuccessListener {
             listener.onSuccess(it.child("contato").value.toString())
        }
    }
}