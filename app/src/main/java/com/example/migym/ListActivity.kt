package com.example.migym

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ListActivity : AppCompatActivity() {

    private lateinit var layoutMisEjercicios: LinearLayout
    private lateinit var txtListaVacia: TextView
    private lateinit var btnAbrirIA: Button
    private lateinit var btnNuevaRutina: Button
    private lateinit var btnCerrarSesion: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        // Enlazamos las vistas del layout
        layoutMisEjercicios = findViewById(R.id.layoutMisEjercicios)
        txtListaVacia = findViewById(R.id.txtListaVacia)
        btnAbrirIA = findViewById(R.id.btnAbrirIA)
        btnNuevaRutina = findViewById(R.id.btnNuevaRutina)
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion)

        btnAbrirIA.setOnClickListener {
            val intent = Intent(this, IaActivity::class.java)
            startActivity(intent)
        }

        btnNuevaRutina.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }

        btnCerrarSesion.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    // onResume se ejecuta cada vez que volvemos a esta pantalla,
    // asi la lista se actualiza con lo que se agrego en la pantalla Agregar
    override fun onResume() {
        super.onResume()
        mostrarMisEjercicios()
    }

    private fun mostrarMisEjercicios() {
        layoutMisEjercicios.removeAllViews()

        // Si todavia no hay nada, mostramos el mensaje y no armamos filas
        if (MisEjercicios.lista.isEmpty()) {
            txtListaVacia.visibility = View.VISIBLE
            return
        }

        txtListaVacia.visibility = View.GONE

        for (ejercicio in MisEjercicios.lista) {
            // Inflamos la fila item_ejercicio.xml y le ponemos el nombre
            val fila = layoutInflater.inflate(R.layout.item_ejercicio, layoutMisEjercicios, false)
            val txtNombre = fila.findViewById<TextView>(R.id.txtNombreEjercicio)
            val btnVer = fila.findViewById<Button>(R.id.btnAccionEjercicio)

            txtNombre.text = ejercicio
            btnVer.text = getString(R.string.btn_ver)

            btnVer.setOnClickListener {
                // Le pasamos el nombre del ejercicio a la pantalla de detalle
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("EJERCICIO_NOMBRE", ejercicio)
                startActivity(intent)
            }

            layoutMisEjercicios.addView(fila)
        }
    }
}
