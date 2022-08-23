package com.br.usemobile.poc_library.common

import android.content.Context
import android.content.Intent
import com.br.usemobile.poc_library.R
import com.br.usemobile.poc_library.view.chat.ChatActivity

class ChatManager : ChatManagerInterface {

    private var _colorPrimary: Int = R.color.teal_700
    val colorPrimary: Int
        get() = _colorPrimary

    private var _colorSecondary: Int = R.color.teal_200
    val colorSecondary: Int
        get() = _colorSecondary

    private var _iconSend: Int = R.drawable.ic_send
    val iconSend: Int
        get() = _iconSend

    companion object {
        private var managerInstance: ChatManager? = null

        fun getManager(): ChatManager {
            if (managerInstance == null) {
                managerInstance = ChatManager()
            }
            return managerInstance as ChatManager
        }
    }

    override fun startActivityBottomSheet(
        context: Context,
        userName: String,
        userCredential: String
    ) {
        configColors(colorPrimary, colorSecondary)
        val user = UserInfo(
            userCredential = userCredential,
            userName = userName
        )
        val i = Intent(context, ChatActivity::class.java)
        i.putExtra("UserInfo", user)
        context.startActivity(i)
    }

    override fun configColors(
        colorPrimary: Int,
        colorSecondary: Int,
    ) {
        _colorPrimary = colorPrimary
        _colorSecondary = colorSecondary
    }

    override fun configIcons(iconSend: Int) {
        _iconSend = iconSend
    }
}