package com.br.usemobile.poc_library

import android.content.Context
import android.content.Intent

class BottomSheetManager {

    private lateinit var activity: BottomSheetActivity


    companion object {
        private var managerInstance: BottomSheetManager? = null

        fun getManager(): BottomSheetManager {
            if (managerInstance == null) {
                managerInstance = BottomSheetManager()
            }
            return managerInstance as BottomSheetManager
        }
    }

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

    fun openBottomSheet() {
        activity.exemploSimples {}
    }

    fun setActivity(activity: BottomSheetActivity) {
        this.activity = activity
    }
}