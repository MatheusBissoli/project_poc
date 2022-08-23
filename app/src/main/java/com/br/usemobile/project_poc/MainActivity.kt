package com.br.usemobile.project_poc

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.br.usemobile.poc_library.common.BottomSheetManager
import com.br.usemobile.poc_library.common.ChatManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val teste = BottomSheetActivity()
//        teste.exemploSimples(this)
//        teste.bottomSheetDialog(supportFragmentManager)

//        Invoke(this).init()
//        BottomSheetActivity().exemploSimples(this, object: ListenerInterface{
//            override fun onClick(string: String) {
//                Toast.makeText(this@MainActivity, string, Toast.LENGTH_SHORT).show()
//            }
//
//        })

//        BottomSheetActivity().exemploSimples(this) {
//            Toast.makeText(this@MainActivity, it, Toast.LENGTH_SHORT).show()
//        }

//        BottomSheetManager.getManager().startActivityBottomSheet(
//            this,
//            title = "",
//            buttonText = "OPEN "
//        )

        ChatManager.getManager().startActivityBottomSheet(
            this,
            userName = "Lary",
            userCredential = "asuhauhsuahsua"
        )

    }

    override fun onResume() {
        super.onResume()
//        Handler(Looper.getMainLooper()).postDelayed({
//            BottomSheetManager.getManager().openExemplo() {
//                Toast.makeText(this@MainActivity, it, Toast.LENGTH_SHORT).show()
//            }
//        }, 5000L)
    }


}