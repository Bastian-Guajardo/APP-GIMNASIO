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

        // Enlazamos las vistas del layout
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
            // Por ahora la respuesta es de ejemplo, todavia no se conecta a internet
            txtRespuestaIA.text = "Tu consulta fue: \"$consulta\". Te recomiendo entrenar con constancia, descansar bien entre series y tomar suficiente agua durante el entrenamiento."
        }

        btnVolverDeIA.setOnClickListener {
            finish()
        }
    }
}
