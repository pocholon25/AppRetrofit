package com.example.appprueba.core.retrofit

import com.example.appprueba.auth.data.network.retrofitclient.PatitasClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://www.kreapps.biz/patitas/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    @Provides
    @Singleton
    fun providePatitasClient(retrofit: Retrofit): PatitasClient {
        return retrofit.create(PatitasClient::class.java)
    }

}