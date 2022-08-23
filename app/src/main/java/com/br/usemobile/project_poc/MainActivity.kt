package com.br.usemobile.project_poc

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.br.usemobile.poc_library.common.ChatManager
import com.br.usemobile.poc_library.common.ListenerInterface

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

        ChatManager.getManager().configIcons(R.drawable.ic_arrow)
        ChatManager.getManager()
            .configColors(colorPrimary = R.color.purple_700, colorSecondary = R.color.purple_200)

        ChatManager.getManager().setListener(
            object : ListenerInterface {
                override fun onInit() {
                    Toast.makeText(this@MainActivity, "Init", Toast.LENGTH_SHORT).show()

                }

                override fun onAuth() {

                }

                override fun onMessageReceived() {
                    Toast.makeText(this@MainActivity, "ReceivedMessage", Toast.LENGTH_SHORT).show()
                }

                override fun onMessageSend() {
                    Toast.makeText(this@MainActivity, "SendMessage", Toast.LENGTH_SHORT).show()

                }
            }
        )
        ChatManager.getManager().startActivityBottomSheet(
            this,
            userName = "Lary",
            userCredential = "asuhauhsuahsua"
        )
    }


}