package com.example.appprueba.auth.domain

import com.example.appprueba.auth.data.network.reponse.LoginResponse
import com.example.appprueba.auth.data.network.request.LoginRequest
import com.example.appprueba.auth.data.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val authRepository: AuthRepository) {

    suspend operator fun invoke(loginRequest: LoginRequest): LoginResponse {
        return authRepository.login(loginRequest)
    }



}