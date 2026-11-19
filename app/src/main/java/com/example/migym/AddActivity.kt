package com.example.migym

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddActivity : AppCompatActivity() {

    private lateinit var spnGrupoMuscular: Spinner
    private lateinit var layoutEjercicios: LinearLayout
    private lateinit var btnVolverDeAgregar: Button

    // Los ejercicios de cada grupo, en el mismo orden que el Spinner
    private val arreglosPorGrupo = intArrayOf(
        R.array.ejercicios_pecho,
        R.array.ejercicios_espalda,
        R.array.ejercicios_piernas,
        R.array.ejercicios_brazos,
        R.array.ejercicios_abdomen
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        // Enlazamos las vistas del layout
        spnGrupoMuscular = findViewById(R.id.spnGrupoMuscular)
        layoutEjercicios = findViewById(R.id.layoutEjercicios)
        btnVolverDeAgregar = findViewById(R.id.btnVolverDeAgregar)

        // Cuando se elige un grupo en el Spinner, mostramos los ejercicios de ese grupo
        spnGrupoMuscular.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(padre: AdapterView<*>?, vista: View?, posicion: Int, id: Long) {
                mostrarEjercicios(posicion)
            }

            override fun onNothingSelected(padre: AdapterView<*>?) {
            }
        }

        btnVolverDeAgregar.setOnClickListener {
            finish()
        }
    }

    // Arma la lista de ejercicios del grupo elegido
    private fun mostrarEjercicios(posicionGrupo: Int) {
        val ejercicios = resources.getStringArray(arreglosPorGrupo[posicionGrupo])

        // Borramos las filas del grupo anterior
        layoutEjercicios.removeAllViews()

        for (ejercicio in ejercicios) {
            // Inflamos la fila item_ejercicio.xml y le ponemos el nombre
            val fila = layoutInflater.inflate(R.layout.item_ejercicio, layoutEjercicios, false)
            val txtNombre = fila.findViewById<TextView>(R.id.txtNombreEjercicio)
            val btnAgregar = fila.findViewById<Button>(R.id.btnAccionEjercicio)

            txtNombre.text = ejercicio
            btnAgregar.text = getString(R.string.btn_mas)

            btnAgregar.setOnClickListener {
                if (MisEjercicios.agregar(ejercicio)) {
                    Toast.makeText(this, "Agregado: $ejercicio", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Ese ejercicio ya esta en tu lista", Toast.LENGTH_SHORT).show()
                }
            }

            layoutEjercicios.addView(fila)
        }
    }
}
