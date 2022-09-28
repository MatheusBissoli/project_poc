package com.br.usemobile.poc_library.data.service.chat

import com.br.usemobile.poc_library.common.ListenerChat
import com.br.usemobile.poc_library.common.ListenerContato
import com.google.firebase.database.*

internal class ChatRealTimeDatabaseImp : ChatRealTimeDatabase {

    val database: DatabaseReference = FirebaseDatabase.getInstance().getReference("users")

    override fun listenerChat(id: String, listener: ListenerChat) {
        database.child(id).child("1").addValueEventListener(object :
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
        database.child(id).child("1").push().setValue(message)
        database.child(contato).child("1").push().setValue(message)
    }

    override fun getContato(id: String, listener: ListenerContato) {
        database.child(id).get().addOnSuccessListener {
             listener.onSuccess(it.child("contato").value.toString())
        }
    }

    override fun createProfileRealDataTime(email: String) {
        database.setValue(email) //enviar um objeto do tipo user
    }


}