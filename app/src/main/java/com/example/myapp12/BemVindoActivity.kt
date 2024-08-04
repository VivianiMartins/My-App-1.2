package com.example.myapp12

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class BemVindoActivity : BaseActivity() {
    private val context: Context get() = this

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Visões
        setContentView(R.layout.activity_bem_vindo)
        val textView = findViewById<TextView>(R.id.textBoasVindas)
        val btNext = findViewById<Button>(R.id.buttonNext)

        //Args
        val args = intent.extras
        val nome = args?.getString("nome")
        textView.text = "$nome, seja bem vindo(a)."


        //ativa o "up navigation" na actions bar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        btNext.setOnClickListener {
            val intent = Intent(context, View2Activity::class.java)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            //Tratamos o clique no botão de voltar (<--)
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}