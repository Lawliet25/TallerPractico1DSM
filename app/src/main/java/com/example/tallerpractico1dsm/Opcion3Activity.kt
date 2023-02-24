package com.example.tallerpractico1dsm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat

class Opcion3Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opcion3)

        var numUnoEdit = findViewById<EditText>(R.id.txtNum1)
        var numDosEdit = findViewById<EditText>(R.id.txtNum2)
        var spinnerEdit = findViewById<Spinner>(R.id.spinner)
        var resultadoText = findViewById<TextView>(R.id.resultadoOp)
        var btnCalcular = findViewById<Button>(R.id.btnCalcular)

        btnCalcular.setOnClickListener(){

            val formatoDecimal = DecimalFormat("0.00")

            var num1 = numUnoEdit.text.toString().toDouble()
            var num2 = numDosEdit.text.toString().toDouble()
            var resultado=0.0
            //Suma
            if (spinnerEdit.selectedItem.toString()=="Suma"){
                resultado = num1 + num2
                val resultadoRedondeado = formatoDecimal.format(resultado)
                resultadoText.text = "El resultado de la operación es: " + resultadoRedondeado.toString()
            }
            //Resta
            if (spinnerEdit.selectedItem.toString()=="Resta"){
                resultado = num1 - num2
                val resultadoRedondeado = formatoDecimal.format(resultado)
                resultadoText.text = "El resultado de la operación es: " + resultadoRedondeado.toString()
            }
            //Multiplicación
            if (spinnerEdit.selectedItem.toString()=="Multiplicación"){
                resultado = num1 * num2
                val resultadoRedondeado = formatoDecimal.format(resultado)
                resultadoText.text = "El resultado de la operación es: " + resultadoRedondeado.toString()
            }
            //División
            if (spinnerEdit.selectedItem.toString()=="División"){
                resultado = num1 / num2
                val resultadoRedondeado = formatoDecimal.format(resultado)
                resultadoText.text = "El resultado de la operación es: " + resultadoRedondeado.toString()
            }

        }

    }
    //Funcionamiento de menú y navegación
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