package com.br.usemobile.poc_library.common

import android.content.Context
import android.content.Intent
import com.br.usemobile.poc_library.view.model.CustomScreen
import com.br.usemobile.poc_library.R
import com.br.usemobile.poc_library.view.BottomSheetActivity

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

    fun openExemplo(callback: (String) -> Unit) {
        activity.exemploSimples {
            callback.invoke(it)
        }
    }

    fun setActivity(activity: BottomSheetActivity) {
        this.activity = activity
    }
}