package com.br.usemobile.poc_library.view.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.br.usemobile.poc_library.databinding.DialogOpenContactBinding


internal class BottomSheetAddContact() : DialogFragment() {

    private lateinit var viewBinding: DialogOpenContactBinding

    private lateinit var onClick: (String) -> Unit


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        DialogOpenContactBinding.inflate(inflater, container, false)
            .also {
                viewBinding = it
            }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
    }

    private fun setUpListeners() {
        viewBinding.buttonAdd.setOnClickListener {
            onClick.invoke(
                viewBinding.editTextContact.text.toString()
                    .replace(".", "")
                    .replace("#", "")
                    .replace("$", "")
                    .replace("[", "")
                    .replace("]", "")
            )
            dismiss()
        }
    }

    fun setOnClick(function: (String) -> Unit) {
        onClick = function
    }


    companion object {

        fun newInstance(): BottomSheetAddContact {
            val frag = BottomSheetAddContact()
            val args = Bundle()
            frag.arguments = args
            return frag
        }
    }
}

