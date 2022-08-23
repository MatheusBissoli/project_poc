package com.br.usemobile.poc_library.common

import android.content.Context
import android.content.Intent
import com.br.usemobile.poc_library.R
import com.br.usemobile.poc_library.view.chat.ChatActivity

class ChatManager {

    companion object {
        private var managerInstance: ChatManager? = null

        fun getManager(): ChatManager {
            if (managerInstance == null) {
                managerInstance = ChatManager()
            }
            return managerInstance as ChatManager
        }
    }

    fun startActivityBottomSheet(
        context: Context,
        colorPrimary: Int = R.color.teal_700,
        colorSecondary: Int = R.color.teal_200,
        userName: String,
        userCredential: String
    ) {
        val customScreen = CustomChat(
            colorPrimary = colorPrimary,
            colorSecondary = colorSecondary
        )
        val user = UserInfo(
            userCredential = userCredential,
            userName = userName
        )
        val i = Intent(context, ChatActivity::class.java)
        i.putExtra("Custom", customScreen)
        i.putExtra("UserInfo", user)
        context.startActivity(i)


    }
}