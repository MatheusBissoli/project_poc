package com.br.usemobile.poc_library.external

import android.content.Context
import android.content.Intent
import com.br.usemobile.poc_library.view.chat.model.CustomScreen
import com.br.usemobile.poc_library.R
import com.br.usemobile.poc_library.view.bottomsheet.BottomSheetActivity

public class BottomSheetManager {

    private lateinit var activity: BottomSheetActivity


    public companion object {
        private var managerInstance: BottomSheetManager? = null

        public  fun getManager(): BottomSheetManager {
            if (managerInstance == null) {
                managerInstance = BottomSheetManager()
            }
            return managerInstance as BottomSheetManager
        }
    }

    public fun startActivityBottomSheet(
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

    public fun startActivityBottomSheet(context: Context) {
        val i = Intent(context, BottomSheetActivity::class.java)
        i.putExtra("Custom", CustomScreen())
        context.startActivity(i)
    }

    public fun openExemplo(callback: (String) -> Unit) {
        activity.exemploSimples {
            callback.invoke(it)
        }
    }

    internal fun setActivity(activity: BottomSheetActivity) {
        this.activity = activity
    }
}