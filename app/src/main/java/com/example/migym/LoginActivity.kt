package com.example.migym

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var edtCorreo: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnIngresar: Button
    private lateinit var btnIrRegistro: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Enlazamos las vistas del layout
        edtCorreo = findViewById(R.id.edtCorreo)
        edtPassword = findViewById(R.id.edtPassword)
        btnIngresar = findViewById(R.id.btnIngresar)
        btnIrRegistro = findViewById(R.id.btnIrRegistro)

        // Al tocar Ingresar revisamos que los campos no esten vacios
        btnIngresar.setOnClickListener {
            val correo = edtCorreo.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            if (correo.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor ingrese correo y contraseña", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, getString(R.string.msg_login_exitoso), Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ListActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        // Lleva a la pantalla de registro
        btnIrRegistro.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
