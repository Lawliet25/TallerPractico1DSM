package com.example.tallerpractico1dsm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

lateinit var nota1 : EditText
lateinit var nota2 : EditText
lateinit var nota3 : EditText
lateinit var nota4 : EditText
lateinit var nota5 : EditText
lateinit var calcular: Button
lateinit var resultado: TextView

class Opcion1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opcion1)

        //Capturando datos y procesándolos
        nota1 = findViewById(R.id.IdNota1)
        nota2 = findViewById(R.id.IdNota2)
        nota3 = findViewById(R.id.IdNota3)
        nota4 = findViewById(R.id.IdNota4)
        nota5 = findViewById(R.id.IdNota5)

        calcular = findViewById(R.id.IdCalcular)

        calcular.setOnClickListener(){



        }
    }








    //Codificando el menú y su navegación
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.menu_muestra, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.menu) {
            Toast.makeText(this, "Se seleccionó la opción: menú inicial", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        if (id == R.id.opcion1) {
            Toast.makeText(this, "Se seleccionó la opción: promedio de un estudiante", Toast.LENGTH_LONG).show()
            val intent = Intent(this, Opcion1Activity::class.java)
            startActivity(intent)
        }
        if (id == R.id.opcion2) {
            Toast.makeText(this, "Se seleccionó la opción: calculadora salarial", Toast.LENGTH_LONG).show()
            val intent = Intent(this, Opcion2Activity::class.java)
            startActivity(intent)
        }
        if (id == R.id.opcion3) {
            Toast.makeText(this, "Se seleccionó la opción: calculadora básica", Toast.LENGTH_LONG).show()
            val intent = Intent(this, Opcion3Activity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}