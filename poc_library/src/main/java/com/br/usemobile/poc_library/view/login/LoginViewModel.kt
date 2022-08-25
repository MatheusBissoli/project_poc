package com.br.usemobile.poc_library.view.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.usemobile.poc_library.common.ListenerFirebase
import com.br.usemobile.poc_library.domain.usecase.LoginUseCase
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


internal class LoginViewModel(
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
            loginUseCase.signInWithEmailPassword(email, password, object : ListenerFirebase {
                override fun onSuccess(user: FirebaseUser) {
                    _login.postValue(user)
                }

                override fun onError(e: Throwable) {
                    _errorLogin.postValue(e)
                }
            })
        }
    }


    fun createUserWithEmailAndPassword(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            loginUseCase.createUserWithEmailPassword(email, password, object : ListenerFirebase {
                override fun onSuccess(user: FirebaseUser) {
                    _createAccount.postValue(user)
                }

                override fun onError(e: Throwable) {
                    _errorCreateAccount.postValue(e)
                }
            })
        }
    }
}