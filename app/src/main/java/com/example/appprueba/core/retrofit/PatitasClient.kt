package com.example.appprueba.core.retrofit

import com.example.appprueba.auth.data.network.reponse.LoginResponse
import com.example.appprueba.auth.data.network.reponse.RegistroResponse
import com.example.appprueba.auth.data.network.request.LoginRequest
import com.example.appprueba.auth.data.network.request.RegistroRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT

interface PatitasClient {

    @POST("login.php")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @PUT("persona.php")
    suspend fun registro(@Body request: RegistroRequest): Response<RegistroResponse>

}