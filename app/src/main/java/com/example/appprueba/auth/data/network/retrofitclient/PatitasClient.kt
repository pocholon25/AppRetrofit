package com.example.appprueba.auth.data.network.retrofitclient

import com.example.appprueba.auth.data.network.reponse.LoginResponse
import com.example.appprueba.auth.data.network.request.LoginRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface PatitasClient {

    @POST("login.php")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>
}