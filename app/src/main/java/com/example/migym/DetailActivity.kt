package com.example.migym

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    private lateinit var txtDetalleNombre: TextView
    private lateinit var btnQuitarEjercicio: Button
    private lateinit var btnVolverLista: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Enlazamos las vistas del layout
        txtDetalleNombre = findViewById(R.id.txtDetalleNombre)
        btnQuitarEjercicio = findViewById(R.id.btnQuitarEjercicio)
        btnVolverLista = findViewById(R.id.btnVolverLista)

        // Recibimos el nombre que nos mando la pantalla de la lista
        val nombre = intent.getStringExtra("EJERCICIO_NOMBRE") ?: ""
        txtDetalleNombre.text = nombre

        btnQuitarEjercicio.setOnClickListener {
            MisEjercicios.quitar(nombre)
            Toast.makeText(this, "Se quito: $nombre", Toast.LENGTH_SHORT).show()
            finish()
        }

        btnVolverLista.setOnClickListener {
            finish()
        }
    }
}
