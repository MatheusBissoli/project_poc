package com.br.usemobile.poc_library

import android.content.Context
import android.content.Intent

class BottomSheetManager {

     fun startActivityBottomSheet(
        context: Context,
        title: String = "ChatTest",
        color: Int = R.color.black,
        buttonText: String = "Open BottomSheet"
    ) {
        val customScreen = CustomScreen(
            title = title,
            color = color,
            buttonText = buttonText
        )
        val i = Intent(context, BottomSheetActivity::class.java)
        i.putExtra("Custom", customScreen)
        context.startActivity(i)

    }

    fun startActivityBottomSheet(context: Context) {
        val i = Intent(context, BottomSheetActivity::class.java)
        i.putExtra("Custom", CustomScreen())
        context.startActivity(i)
    }
}