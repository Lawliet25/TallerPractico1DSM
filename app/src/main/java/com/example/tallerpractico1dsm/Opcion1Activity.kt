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
import java.text.DecimalFormat

class Opcion1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opcion1)

        //Capturando datos y procesándolos
        var nota1Edit = findViewById<EditText>(R.id.IdNota1)
        var nota2Edit = findViewById<EditText>(R.id.IdNota2)
        var nota3Edit = findViewById<EditText>(R.id.IdNota3)
        var nota4Edit = findViewById<EditText>(R.id.IdNota4)
        var nota5Edit = findViewById<EditText>(R.id.IdNota5)

        var calcular = findViewById<Button>(R.id.IdCalcular)

        //Capturando evento listener de botón
        calcular.setOnClickListener(){

            var nota1 = nota1Edit.text.toString().toDouble()
            var nota2 = nota2Edit.text.toString().toDouble()
            var nota3 = nota3Edit.text.toString().toDouble()
            var nota4 = nota4Edit.text.toString().toDouble()
            var nota5 = nota5Edit.text.toString().toDouble()

            //Promedio
            var promedio = (nota1 + nota2 + nota3 + nota4 + nota5)/5

            //Formato de 2 decimales
            val formatoDecimal = DecimalFormat("0.00")
            val resultadoRedondeado = formatoDecimal.format(promedio)

            //Imprimiendo resultado
            var resultado = findViewById<TextView>(R.id.IdResultado)
            resultado.text = resultadoRedondeado.toString()

            var aprobo = findViewById<TextView>(R.id.aprobo)
            if (resultadoRedondeado>="6.0"){
                aprobo.text = "¡Usted ha aprobado, felicidades!"
            } else{
                aprobo.text = "Usted reprobó."
            }
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