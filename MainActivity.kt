package com.kmganhos.motorista

import android.app.Activity
import android.content.Intent
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

        atualizarResumo()
    }

    override fun onResume() {
        super.onResume()
        atualizarResumo()
    }

    private fun atualizarResumo() {
        txtKm.text = "Total KM: $totalKm km"
        txtGanhos.text = "Ganhos: R$ $totalGanhos"
    }
}
