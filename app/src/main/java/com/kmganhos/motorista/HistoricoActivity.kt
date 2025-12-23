package com.kmganhos.motorista

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HistoricoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico)

        val txtHistorico = findViewById<TextView>(R.id.txtHistorico)
        val lista = HistoricoManager.listarCorridas(this)

        if (lista.isEmpty()) {
            txtHistorico.text = "Nenhuma corrida registrada"
        } else {
            val texto = lista.joinToString("\n\n") {
                "📅 ${it.data}\nKM: ${it.km}\nR$ ${it.valor}"
            }
            txtHistorico.text = texto
        }
    }
}
