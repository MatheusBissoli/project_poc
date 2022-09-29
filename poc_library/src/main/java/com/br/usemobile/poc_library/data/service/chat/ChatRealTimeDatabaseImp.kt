package com.br.usemobile.poc_library.data.service.chat

import com.br.usemobile.poc_library.common.ListenerChat
import com.br.usemobile.poc_library.common.ListenerContato
import com.br.usemobile.poc_library.common.ListenerContato2
import com.br.usemobile.poc_library.data.models.ContactModel
import com.br.usemobile.poc_library.data.models.MessageModel
import com.br.usemobile.poc_library.data.models.UserModel
import com.google.firebase.database.*

internal class ChatRealTimeDatabaseImp : ChatRealTimeDatabase {

    val database: DatabaseReference = FirebaseDatabase.getInstance().getReference("users")

    override fun listenerChat(id: String, contato: String, listener: ListenerChat) {
        database.child(id).child("contatos").child(contato).child("conversation").addValueEventListener(object :
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
        val message1 = MessageModel(
            id = id,
            message = message
        )
        val message2 = MessageModel(
            id = id,
            message = message
        )
        database.child(id).child("contatos").child(contato).child("conversation").push().setValue(message1)
        database.child(contato).child("contatos").child(id).child("conversation").push().setValue(message2)
    }

    override fun getContato(id: String, listener: ListenerContato) {
        database.child(id).child("contatos").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var email = ""
                for (it in snapshot.children) {
                    email = it.child("email").getValue().toString()
                }

                listener.onSuccess(email)
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

    override fun createContact(idEmail: String, contact: String, listener: ListenerContato) {
        val newContact = ContactModel(
            email = contact
        )
        val newContact2 = ContactModel(
            email = idEmail
        )
        database.child(idEmail).child("contatos").child(contact).setValue(newContact)
        database.child(contact).child("contatos").child(idEmail).setValue(newContact2)
            .addOnSuccessListener {
                listener.onSuccess("")
            }
    }

    override fun createProfileRealDataTime(email: String) {
        val userModel = UserModel(
            email = email,
            contacts = arrayListOf()
        )
        database.child(
            email.replace(".", "")
                .replace("#", "")
                .replace("$", "")
                .replace("[", "")
                .replace("]", "")
        ).setValue(userModel) //enviar um objeto do tipo user
    }


}