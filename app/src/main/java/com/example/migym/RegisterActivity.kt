package com.example.migym

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var edtNombre: EditText
    private lateinit var edtCorreoRegistro: EditText
    private lateinit var edtTelefono: EditText
    private lateinit var edtPasswordRegistro: EditText
    private lateinit var edtConfirmarPassword: EditText
    private lateinit var rgNivelEntrenamiento: RadioGroup
    private lateinit var cbTerminos: CheckBox
    private lateinit var btnRegistrar: Button
    private lateinit var btnVolverLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Inicialización de componentes con sus respectivos IDs
        edtNombre = findViewById(R.id.edtNombre)
        edtCorreoRegistro = findViewById(R.id.edtCorreoRegistro)
        edtTelefono = findViewById(R.id.edtTelefono)
        edtPasswordRegistro = findViewById(R.id.edtPasswordRegistro)
        edtConfirmarPassword = findViewById(R.id.edtConfirmarPassword)
        rgNivelEntrenamiento = findViewById(R.id.rgNivelEntrenamiento)
        cbTerminos = findViewById(R.id.cbTerminos)
        btnRegistrar = findViewById(R.id.btnRegistrar)
        btnVolverLogin = findViewById(R.id.btnVolverLogin)

        btnRegistrar.setOnClickListener {
            val pass1 = edtPasswordRegistro.text.toString()
            val pass2 = edtConfirmarPassword.text.toString()

            if (!cbTerminos.isChecked) {
                Toast.makeText(this, "Debe aceptar los términos y condiciones", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (pass1.isEmpty() || pass2.isEmpty()) {
                Toast.makeText(this, "Debe ingresar y confirmar la contraseña", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (pass1 != pass2) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, getString(R.string.msg_registro_exitoso), Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnVolverLogin.setOnClickListener {
            finish()
        }
    }
}
