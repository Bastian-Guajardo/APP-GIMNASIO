package com.example.migym

/**
 * Aqui se guardan los ejercicios que la persona va agregando.
 * Es una lista en memoria: se borra al cerrar la app, pero sirve
 * para que la pantalla Agregar y la pantalla Lista compartan los datos.
 */
object MisEjercicios {

    val lista = mutableListOf<String>()

    // Agrega un ejercicio solo si no estaba ya en la lista
    fun agregar(ejercicio: String): Boolean {
        if (lista.contains(ejercicio)) {
            return false
        }
        lista.add(ejercicio)
        return true
    }

    fun quitar(ejercicio: String) {
        lista.remove(ejercicio)
    }
}
