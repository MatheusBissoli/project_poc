package com.br.usemobile.poc_library.common

import com.br.usemobile.poc_library.data.models.ContactModel

internal interface ListenerContato {

    fun onSuccess(contato: String)
}

internal interface ListenerContato2 {

    fun onSuccess(contato: ContactModel?)
}