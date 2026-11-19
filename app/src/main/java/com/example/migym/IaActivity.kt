package com.example.migym

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class IaActivity : AppCompatActivity() {

    private lateinit var edtPromptIA: EditText
    private lateinit var btnPreguntarIA: Button
    private lateinit var txtRespuestaIA: TextView
    private lateinit var btnVolverDeIA: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ia)

        // Componentes según identificadores de la rúbrica (listos para Gemini)
        edtPromptIA = findViewById(R.id.edtPromptIA)
        btnPreguntarIA = findViewById(R.id.btnPreguntarIA)
        txtRespuestaIA = findViewById(R.id.txtRespuestaIA)
        btnVolverDeIA = findViewById(R.id.btnVolverDeIA)

        btnPreguntarIA.setOnClickListener {
            val consulta = edtPromptIA.text.toString().trim()
            if (consulta.isEmpty()) {
                Toast.makeText(this, "Por favor ingrese su consulta para el Entrenador IA", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, getString(R.string.msg_ia_procesando), Toast.LENGTH_SHORT).show()
            // Simulación interactiva de respuesta mientras se integra el SDK de Gemini en Unidad 3
            txtRespuestaIA.text = "¡Excelente consulta! Para optimizar: \"$consulta\", te sugiero mantener series efectivas cerca del RIR 1-2, hidratación con electrolitos y un superávit o déficit calórico controlado según tu objetivo."
        }

        btnVolverDeIA.setOnClickListener {
            finish()
        }
    }
}
