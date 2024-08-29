package com.example.appprueba.auth.domain

import com.example.appprueba.auth.data.network.reponse.RegistroResponse
import com.example.appprueba.auth.data.network.request.RegistroRequest
import com.example.appprueba.auth.data.repository.AuthRepository
import javax.inject.Inject

class RegistroUseCase @Inject constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(registroRequest: RegistroRequest): RegistroResponse {
        return repository.registro(registroRequest)
    }

}