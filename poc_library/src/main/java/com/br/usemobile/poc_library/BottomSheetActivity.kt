package com.br.usemobile.poc_library

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.br.usemobile.poc_library.databinding.BottomSheetActivityBinding
import com.br.usemobile.testepoc.MyBottomSheetDialogFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior

class Invoke(private val context: Context) : AppCompatActivity() {

    fun init() {
        context.startActivity(Intent(context, BottomSheetActivity::class.java))
    }
}

class BottomSheetActivity : AppCompatActivity() {

    var binding: BottomSheetActivityBinding? = null
    lateinit var customLayout: CustomScreen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = BottomSheetActivityBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setActivityManager()
        getIntentScreen()
        setUpLayout()
//        exemploSimples()
//        exemploCustomizado()
//        bottomSheetDialog()
        openHideBottomSheet()
    }

    private fun getIntentScreen(){
        customLayout = intent.getSerializableExtra("Custom") as CustomScreen
    }

    private fun setUpLayout(){
        binding?.buttonTeste?.text = customLayout.buttonText
    }

    private fun setActivityManager(){
        BottomSheetManager.getManager().setActivity(activity = this)
    }


    fun bottomSheetDialog(supportFragmentManager: FragmentManager) {
        MyBottomSheetDialogFragment().apply {
            show(supportFragmentManager, tag)
        }
    }

    fun openHideBottomSheet() {
        binding?.buttonTeste?.apply {
            visibility = View.VISIBLE
            val myBottomSheet = binding?.myBottomSheet?.root
            setOnClickListener {
                val bottomSheetBehaviour = BottomSheetBehavior.from(myBottomSheet!!)
                if (bottomSheetBehaviour.state == BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetBehaviour.state = BottomSheetBehavior.STATE_COLLAPSED
                } else {
                    bottomSheetBehaviour.state = BottomSheetBehavior.STATE_EXPANDED
                }
            }
        }
    }

    fun exemploSimples(context: Context , listenerInterface: ListenerInterface) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(context);
        builder.setTitle("Titulo")
        builder.setMessage("Qualifique este software")
        builder.setPositiveButton("Positivo", object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
//                Toast.makeText(
//                    context,
//                    "positivo",
//                    Toast.LENGTH_SHORT
//                ).show()
                listenerInterface.onClick("positivo")
            }
        })
        builder.setNegativeButton("Negativo", object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
//                Toast.makeText(
//                    context,
//                    "negativo",
//                    Toast.LENGTH_SHORT
//                ).show()
                listenerInterface.onClick("negativo")
            }
        })
        val alerta = builder.create()
        alerta.show()
    }

    fun exemploSimples(context: Context = this, callback: (String) -> Unit) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(context);
        builder.setTitle("Titulo")
        builder.setMessage("Qualifique este software")

        builder.setPositiveButton("Positivo", object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
//                Toast.makeText(
//                    context,
//                    "positivo",
//                    Toast.LENGTH_SHORT
//                ).show()
                callback.invoke("positivo")
            }
        })
        builder.setNegativeButton("Negativo", object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
//                Toast.makeText(
//                    context,
//                    "negativo",
//                    Toast.LENGTH_SHORT
//                ).show()
                callback.invoke("negativo")
            }
        })
        val alerta = builder.create()
        alerta.show()
    }

    fun exemploCustomizado() {
        val li = layoutInflater
        val view: View = li.inflate(R.layout.custom_dialog, null)
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Titulo")
        builder.setView(view)
        val alerta = builder.create()
        view.findViewById<Button>(R.id.bt).setOnClickListener(object : View.OnClickListener {
            override fun onClick(arg0: View?) {
                Toast.makeText(
                    this@BottomSheetActivity,
                    "alerta.dismiss()",
                    Toast.LENGTH_SHORT
                ).show()
                alerta.dismiss()
            }
        })
        alerta.show()

    }

}