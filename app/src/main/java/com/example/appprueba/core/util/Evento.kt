package com.example.appprueba.core.util

open class Evento<out T>(private val contenido: T) {

    var hasBeenHandler = false
        private set

    fun obtenerContenidoSiCamnbio(): T? {
        return if (hasBeenHandler) {
            null
        } else {
            hasBeenHandler = true
            contenido
        }
    }

    fun obtenerContenido(): T = contenido
}