package com.br.usemobile.poc_library.external

import android.content.Context

interface ChatManagerInterface {

    fun configColors(colorPrimary: Int, colorSecondary: Int)

    fun startActivityBottomSheet(
        context: Context,
        userName: String,
        userCredential: String
    )

    fun configIcons(iconSend: Int)

    fun setListener(listener: ListenerInterface)

    fun notifyReceivedMessage()

    fun notifySendMessage()

    fun notifyInit()

}