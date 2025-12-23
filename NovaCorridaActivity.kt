package com.kmganhos.motorista

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class NovaCorridaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nova_corrida)

        val edtKm = findViewById<EditText>(R.id.edtKm)
        val edtValor = findViewById<EditText>(R.id.edtValor)
        val btnSalvar = findViewById<Button>(R.id.btnSalvar)

        btnSalvar.setOnClickListener {
            val km = edtKm.text.toString().toDoubleOrNull() ?: 0.0
            val valor = edtValor.text.toString().toDoubleOrNull() ?: 0.0

            MainActivity.totalKm += km
            MainActivity.totalGanhos += valor

            finish()
        }
    }
}
