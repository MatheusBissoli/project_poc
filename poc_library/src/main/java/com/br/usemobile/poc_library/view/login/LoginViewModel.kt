package com.br.usemobile.poc_library.view.login

import androidx.lifecycle.ViewModel
import com.br.usemobile.poc_library.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {
}