package com.kmganhos.motorista

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        var totalKm = 0.0
        var totalGanhos = 0.0
    }

    private lateinit var txtKm: TextView
    private lateinit var txtGanhos: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtKm = findViewById(R.id.txtTotalKm)
        txtGanhos = findViewById(R.id.txtTotalGanhos)

        carregarDados()
        atualizarResumo()
    }

    override fun onPause() {
        super.onPause()
        salvarDados()
    }

    private fun atualizarResumo() {
        txtKm.text = "Total KM: $totalKm km"
        txtGanhos.text = "Ganhos: R$ $totalGanhos"
    }

    private fun salvarDados() {
        val prefs = getSharedPreferences("dados_motorista", Context.MODE_PRIVATE)
        val editor = prefs.edit()

        editor.putFloat("totalKm", totalKm.toFloat())
        editor.putFloat("totalGanhos", totalGanhos.toFloat())
        editor.apply()
    }

    private fun carregarDados() {
        val prefs = getSharedPreferences("dados_motorista", Context.MODE_PRIVATE)
        totalKm = prefs.getFloat("totalKm", 0f).toDouble()
        totalGanhos = prefs.getFloat("totalGanhos", 0f).toDouble()
    }
}
