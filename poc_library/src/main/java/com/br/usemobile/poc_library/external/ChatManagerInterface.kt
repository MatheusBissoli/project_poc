package com.br.usemobile.poc_library.external

import android.content.Context

public interface ChatManagerInterface {

    public fun configColors(colorPrimary: Int, colorSecondary: Int)

    public fun startActivityBottomSheet(
        context: Context,
        userName: String,
        userCredential: String
    )

    public fun configIcons(iconSend: Int)

    public fun setListener(listener: ListenerInterface)

    public fun notifyReceivedMessage()

    public fun notifySendMessage()

    public fun notifyInit()

}