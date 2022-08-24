package com.br.usemobile.poc_library.domain.usecase

import com.br.usemobile.poc_library.domain.repository.LoginRepository
import com.br.usemobile.poc_library.domain.usecase.LoginUseCase

internal class LoginUseCaseImp(
    private val loginRepository: LoginRepository
) : LoginUseCase {

}