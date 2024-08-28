package com.example.appprueba.core.ruta

sealed class RutaPatitas (val path: String){

    object loginScreen : RutaPatitas("loginScreen")
    object registroScreen : RutaPatitas("registroScreen")
    object homeScreen : RutaPatitas("homeScreen")

}