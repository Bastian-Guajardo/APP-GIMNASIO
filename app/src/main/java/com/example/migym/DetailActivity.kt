package com.example.migym

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    private lateinit var txtDetalleNombre: TextView
    private lateinit var txtDetalleMusculos: TextView
    private lateinit var txtDetalleTiempo: TextView
    private lateinit var txtDetalleEjercicios: TextView
    private lateinit var txtDetalleDescanso: TextView
    private lateinit var cbMarcarFavorita: CheckBox
    private lateinit var btnMarcarCompletada: Button
    private lateinit var btnEditarRutina: Button
    private lateinit var btnEliminarRutina: Button
    private lateinit var btnVolverLista: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        txtDetalleNombre = findViewById(R.id.txtDetalleNombre)
        txtDetalleMusculos = findViewById(R.id.txtDetalleMusculos)
        txtDetalleTiempo = findViewById(R.id.txtDetalleTiempo)
        txtDetalleEjercicios = findViewById(R.id.txtDetalleEjercicios)
        txtDetalleDescanso = findViewById(R.id.txtDetalleDescanso)
        cbMarcarFavorita = findViewById(R.id.cbMarcarFavorita)
        btnMarcarCompletada = findViewById(R.id.btnMarcarCompletada)
        btnEditarRutina = findViewById(R.id.btnEditarRutina)
        btnEliminarRutina = findViewById(R.id.btnEliminarRutina)
        btnVolverLista = findViewById(R.id.btnVolverLista)

        val nombreRecibido = intent.getStringExtra("RUTINA_NOMBRE")
        if (!nombreRecibido.isNullOrEmpty()) {
            txtDetalleNombre.text = nombreRecibido
        }

        // Acción: Marcar como Completada
        btnMarcarCompletada.setOnClickListener {
            Toast.makeText(this, getString(R.string.msg_rutina_completada), Toast.LENGTH_SHORT).show()
        }

        // Acción: Marcar Favorita
        cbMarcarFavorita.setOnCheckedChangeListener { _, isChecked ->
            val msg = if (isChecked) "Rutina guardada en favoritas" else "Rutina removida de favoritas"
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

        // Acción: Editar
        btnEditarRutina.setOnClickListener {
            Toast.makeText(this, getString(R.string.msg_rutina_editada), Toast.LENGTH_SHORT).show()
        }

        // Acción: Eliminar
        btnEliminarRutina.setOnClickListener {
            Toast.makeText(this, getString(R.string.msg_rutina_eliminada), Toast.LENGTH_SHORT).show()
            finish()
        }

        // Volver
        btnVolverLista.setOnClickListener {
            finish()
        }
    }
}
