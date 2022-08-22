package com.br.usemobile.project_poc

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.br.usemobile.poc_library.BottomSheetManager
import kotlinx.coroutines.delay

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

        BottomSheetManager.getManager().startActivityBottomSheet(
            this,
            title = "",
            buttonText = "OPEN "
        )

    }

    override fun onResume() {
        super.onResume()
        Handler(Looper.getMainLooper()).postDelayed({
            BottomSheetManager.getManager().openBottomSheet()
        }, 5000L)
    }


}