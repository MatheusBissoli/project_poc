package com.br.usemobile.project_poc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.br.usemobile.poc_library.Invoke

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val teste = BottomSheetActivity()
//        teste.exemploSimples(this)
//        teste.bottomSheetDialog(supportFragmentManager)

        Invoke(this).init()
    }

}