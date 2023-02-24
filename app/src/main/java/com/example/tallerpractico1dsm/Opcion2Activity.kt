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

class Opcion2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opcion2)

        var nombreEdit = findViewById<EditText>(R.id.txtNombre)
        var salarioEdit = findViewById<EditText>(R.id.txtSalario)
        var calcular = findViewById<Button>(R.id.buttonCalcular)
        var resultadoText = findViewById<TextView>(R.id.lblSalarioNeto)
        var deduccionIsss  = findViewById<TextView>(R.id.lblIsss)
        var deduccionAfp  = findViewById<TextView>(R.id.lblAfp)
        var deduccionRenta  = findViewById<TextView>(R.id.lblRenta)

        calcular.setOnClickListener(){

            var nombre = nombreEdit.text.toString()
            var salarioBase = salarioEdit.text.toString().toDouble()


            //Varibles de deducciones
            var isss = 0.03
            var afp = 0.04
            var renta = 0.05

            var deduccion1 = (salarioBase*isss)
            var deduccion2 = (salarioBase*afp)
            var deduccion3 = (salarioBase*renta)

            //Formato de 2 decimales
            val formatoDecimal = DecimalFormat("0.00")
            var salarioNeto = salarioBase-deduccion1-deduccion2-deduccion3
            val resultadoRedondeado = formatoDecimal.format(salarioNeto)

            //Imprimiendo
            val deduccionRedondeada1 = formatoDecimal.format(deduccion1)
            deduccionIsss.text = "Descuento de ISSS 3%: $" + deduccionRedondeada1.toString()

            val deduccionRedondeada2 = formatoDecimal.format(deduccion2)
            deduccionAfp.text = "Descuento de AFP 4%: $" + deduccionRedondeada2.toString()

            val deduccionRedondeada3 = formatoDecimal.format(deduccion3)
            deduccionRenta.text = "Descuento de Renta 5%: $" + deduccionRedondeada3.toString()

            resultadoText.text = nombre + " su salario neto es: $" + resultadoRedondeado.toString()
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