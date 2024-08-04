package com.example.myapp12

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.GridView

class View2Activity : BaseActivity() {
    private val context: Context get() = this

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Visões
        setContentView(R.layout.activity_view2)
        val gridView = findViewById<GridView>(R.id.boxView)
        val btNext = findViewById<Button>(R.id.buttonNext)

        // Colocando texto
        val data = arrayOf(
            "Algoritmos",
            "Estruturas de Dados",
            "Programação Orientada a Objetos",
            "Banco de Dados",
            "Redes de Computadores",
            "Engenharia de Software",
            "Inteligência Artificial",
            "Sistemas Operacionais",
            "Criptografia",
            "Desenvolvimento Web",
            "Computação Gráfica",
            "Segurança da Informação",
            "Aprendizado de Máquina",
            "Computação em Nuvem",
            "Cibersegurança"
        )

        val adapter = GridAdapter(this, data)
        gridView.adapter = adapter

        // Activate the "up navigation" in the action bar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        btNext.setOnClickListener {
            val intent = Intent(context, View3Activity::class.java)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            // Handle the click on the back button (<--)
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
