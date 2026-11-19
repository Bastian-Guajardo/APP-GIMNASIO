package com.example.migym

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddActivity : AppCompatActivity() {

    private lateinit var edtNombreRutina: EditText
    private lateinit var edtGrupoMuscular: EditText
    private lateinit var edtDuracionMinutos: EditText
    private lateinit var edtDiasSemana: EditText
    private lateinit var edtSeriesRepeticiones: EditText
    private lateinit var edtDescripcion: EditText
    private lateinit var btnGuardarRutina: Button
    private lateinit var btnCancelarRutina: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        edtNombreRutina = findViewById(R.id.edtNombreRutina)
        edtGrupoMuscular = findViewById(R.id.edtGrupoMuscular)
        edtDuracionMinutos = findViewById(R.id.edtDuracionMinutos)
        edtDiasSemana = findViewById(R.id.edtDiasSemana)
        edtSeriesRepeticiones = findViewById(R.id.edtSeriesRepeticiones)
        edtDescripcion = findViewById(R.id.edtDescripcion)
        btnGuardarRutina = findViewById(R.id.btnGuardarRutina)
        btnCancelarRutina = findViewById(R.id.btnCancelarRutina)

        btnGuardarRutina.setOnClickListener {
            val nombre = edtNombreRutina.text.toString().trim()
            if (nombre.isEmpty()) {
                Toast.makeText(this, "Por favor ingrese el nombre de la rutina", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, getString(R.string.msg_rutina_guardada), Toast.LENGTH_SHORT).show()
            finish()
        }

        btnCancelarRutina.setOnClickListener {
            finish()
        }
    }
}
