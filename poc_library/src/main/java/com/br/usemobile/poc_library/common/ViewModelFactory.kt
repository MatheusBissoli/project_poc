package com.br.usemobile.poc_library.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.br.usemobile.poc_library.data.service.chat.ChatFirebase
import com.br.usemobile.poc_library.domain.usecase.login.LoginUseCase
import com.br.usemobile.poc_library.view.chat.ChatViewModel
import com.br.usemobile.poc_library.view.login.LoginViewModel

internal class LoginViewModelFactory(private val useCase: LoginUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            LoginViewModel(useCase) as T
        } else {
            throw Throwable("ViewModel not found")
        }

}

internal class ChatViewModelFactory(private val chatFirebase: ChatFirebase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        if (modelClass.isAssignableFrom(ChatViewModel::class.java)) {
            ChatViewModel(chatFirebase) as T
        } else {
            throw Throwable("ViewModel not found")
        }

}