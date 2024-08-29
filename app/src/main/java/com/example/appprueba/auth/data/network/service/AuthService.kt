package com.example.appprueba.auth.data.network.service

import com.example.appprueba.auth.data.network.reponse.LoginResponse
import com.example.appprueba.auth.data.network.reponse.RegistroResponse
import com.example.appprueba.auth.data.network.request.LoginRequest
import com.example.appprueba.auth.data.network.request.RegistroRequest
import com.example.appprueba.core.retrofit.PatitasClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthService @Inject constructor(private val patitasClient: PatitasClient) {

    suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return withContext(Dispatchers.IO) {
            val response = patitasClient.login(loginRequest)
            response.body()!!
        }
    }

    suspend fun registro(request: RegistroRequest): RegistroResponse {
        return withContext(Dispatchers.IO) {
            val response = patitasClient.registro(request)
            response.body()!!
        }

    }
}