package com.example.appprueba.auth.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appprueba.auth.data.network.reponse.LoginResponse
import com.example.appprueba.auth.data.network.request.LoginRequest
import com.example.appprueba.auth.domain.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase): ViewModel(){

    private val _usuario = MutableLiveData<String>()
    val usuario: LiveData<String> = _usuario

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isButtonLoginHabilitado = MutableLiveData<Boolean>()
    var isButtonLoginHabilitado: LiveData<Boolean> = _isButtonLoginHabilitado

    private val _loginResponse = MutableLiveData<LoginResponse>()
    val loginResponse: LiveData<LoginResponse> = _loginResponse

    fun onValueChanged(usuario: String, password: String){
        _usuario.value = usuario
        _password.value = password
        _isButtonLoginHabilitado.value = habilitarBotonLogin(usuario, password)
    }

    fun habilitarBotonLogin(usuario: String, password: String)=usuario.length>2 && password.length>2

    fun loginUsuarioPassword(){
        viewModelScope.launch {
            val response = loginUseCase(LoginRequest(usuario.value!!, password.value!!))
            _loginResponse.value = response
        }
    }
}