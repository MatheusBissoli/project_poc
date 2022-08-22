package com.br.usemobile.project_poc

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.br.usemobile.poc_library.BottomSheetActivity
import com.br.usemobile.poc_library.Invoke
import com.br.usemobile.poc_library.ListenerInterface

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

        BottomSheetActivity().exemploSimples(this) {
            Toast.makeText(this@MainActivity, it, Toast.LENGTH_SHORT).show()
        }
    }

}