package com.kmganhos.motorista

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

object HistoricoManager {

    private const val PREFS_NAME = "historico_corridas"
    private const val KEY_LISTA = "lista"

    fun salvarCorrida(context: Context, corrida: Corrida) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val listaAtual = prefs.getString(KEY_LISTA, "[]")

        val jsonArray = JSONArray(listaAtual)
        val json = JSONObject()

        json.put("data", corrida.data)
        json.put("km", corrida.km)
        json.put("valor", corrida.valor)

        jsonArray.put(json)

        prefs.edit().putString(KEY_LISTA, jsonArray.toString()).apply()
    }

    fun listarCorridas(context: Context): List<Corrida> {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val lista = prefs.getString(KEY_LISTA, "[]")

        val jsonArray = JSONArray(lista)
        val corridas = mutableListOf<Corrida>()

        for (i in 0 until jsonArray.length()) {
            val item = jsonArray.getJSONObject(i)
            corridas.add(
                Corrida(
                    item.getString("data"),
                    item.getDouble("km"),
                    item.getDouble("valor")
                )
            )
        }

        return corridas
    }
}
