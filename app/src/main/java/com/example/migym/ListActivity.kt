package com.example.migym

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ListActivity : AppCompatActivity() {

    private lateinit var btnAbrirIA: Button
    private lateinit var btnNuevaRutina: Button
    private lateinit var btnVerDetalle1: Button
    private lateinit var btnVerDetalle2: Button
    private lateinit var btnVerDetalle3: Button
    private lateinit var btnCerrarSesion: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        btnAbrirIA = findViewById(R.id.btnAbrirIA)
        btnNuevaRutina = findViewById(R.id.btnNuevaRutina)
        btnVerDetalle1 = findViewById(R.id.btnVerDetalle1)
        btnVerDetalle2 = findViewById(R.id.btnVerDetalle2)
        btnVerDetalle3 = findViewById(R.id.btnVerDetalle3)
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion)

        // Abrir pantalla de IA
        btnAbrirIA.setOnClickListener {
            val intent = Intent(this, IaActivity::class.java)
            startActivity(intent)
        }

        // Abrir pantalla para agregar nueva rutina
        btnNuevaRutina.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }

        // Ver detalle de la rutina 1
        btnVerDetalle1.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("RUTINA_NOMBRE", getString(R.string.rutina1_nombre))
            startActivity(intent)
        }

        // Ver detalle de la rutina 2
        btnVerDetalle2.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("RUTINA_NOMBRE", getString(R.string.rutina2_nombre))
            startActivity(intent)
        }

        // Ver detalle de la rutina 3
        btnVerDetalle3.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("RUTINA_NOMBRE", getString(R.string.rutina3_nombre))
            startActivity(intent)
        }

        // Cerrar sesión y volver al Login
        btnCerrarSesion.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
