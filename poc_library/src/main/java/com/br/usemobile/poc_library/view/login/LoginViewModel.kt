package com.br.usemobile.poc_library.view.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.usemobile.poc_library.domain.usecase.LoginUseCase
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch


internal class LoginViewModel (
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _login: MutableLiveData<FirebaseUser?> =
        MutableLiveData()
    val login: LiveData<FirebaseUser?>
        get() = _login

    private val _errorLogin: MutableLiveData<Throwable> =
        MutableLiveData()
    val errorLogin: LiveData<Throwable>
        get() = _errorLogin

    private val _createAccount: MutableLiveData<FirebaseUser?> =
        MutableLiveData()
    val createAccount: LiveData<FirebaseUser?>
        get() = _createAccount

    private val _errorCreateAccount: MutableLiveData<Throwable> =
        MutableLiveData()
    val errorCreateAccount: LiveData<Throwable>
        get() = _errorCreateAccount

    fun signInWithEmailAndPassword(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
               loginUseCase.signInWithEmailPassword(email, password).catch { error ->
                _errorCreateAccount.postValue(error)
            }.collect {
                _createAccount.postValue(it)
            }
        }
    }


    fun signUpWithEmailAndPassword(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            loginUseCase.signUpWithEmailPassword(email, password).catch { error ->
                _errorLogin.postValue(error)
            }.collect {
                _login.postValue(it)
            }
        }
    }
}