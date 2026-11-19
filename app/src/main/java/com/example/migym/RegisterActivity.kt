package com.example.migym

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var edtNombre: EditText
    private lateinit var edtCorreoRegistro: EditText
    private lateinit var edtPasswordRegistro: EditText
    private lateinit var rgNivelEntrenamiento: RadioGroup
    private lateinit var cbFuerza: CheckBox
    private lateinit var cbDefinicion: CheckBox
    private lateinit var cbSalud: CheckBox
    private lateinit var btnRegistrar: Button
    private lateinit var btnVolverLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Enlazamos las vistas del layout
        edtNombre = findViewById(R.id.edtNombre)
        edtCorreoRegistro = findViewById(R.id.edtCorreoRegistro)
        edtPasswordRegistro = findViewById(R.id.edtPasswordRegistro)
        rgNivelEntrenamiento = findViewById(R.id.rgNivelEntrenamiento)
        cbFuerza = findViewById(R.id.cbFuerza)
        cbDefinicion = findViewById(R.id.cbDefinicion)
        cbSalud = findViewById(R.id.cbSalud)
        btnRegistrar = findViewById(R.id.btnRegistrar)
        btnVolverLogin = findViewById(R.id.btnVolverLogin)

        btnRegistrar.setOnClickListener {
            val nombre = edtNombre.text.toString().trim()
            val correo = edtCorreoRegistro.text.toString().trim()
            val password = edtPasswordRegistro.text.toString().trim()

            // Revisamos que no falte ningun dato
            if (nombre.isEmpty() || correo.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Debe completar todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Del RadioGroup sacamos la unica opcion que quedo marcada
            val idNivel = rgNivelEntrenamiento.checkedRadioButtonId
            val nivel = findViewById<RadioButton>(idNivel).text.toString()

            // De los CheckBox juntamos todas las opciones marcadas
            val enfoques = mutableListOf<String>()
            if (cbFuerza.isChecked) enfoques.add(cbFuerza.text.toString())
            if (cbDefinicion.isChecked) enfoques.add(cbDefinicion.text.toString())
            if (cbSalud.isChecked) enfoques.add(cbSalud.text.toString())

            if (enfoques.isEmpty()) {
                Toast.makeText(this, "Debe elegir al menos un enfoque", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Mostramos un resumen con lo que eligio la persona
            val resumen = "Cuenta creada. Nivel: $nivel. Enfoque: " + enfoques.joinToString(", ")
            Toast.makeText(this, resumen, Toast.LENGTH_LONG).show()

            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnVolverLogin.setOnClickListener {
            finish()
        }
    }
}
