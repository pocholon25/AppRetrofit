package com.example.appprueba.auth.data.repository

import com.example.appprueba.auth.data.network.reponse.LoginResponse
import com.example.appprueba.auth.data.network.request.LoginRequest
import com.example.appprueba.auth.data.network.service.AuthService
import javax.inject.Inject

class AuthRepository @Inject constructor(private val authService: AuthService) {

    suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return authService.login(loginRequest)
    }
}