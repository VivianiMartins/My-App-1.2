package com.example.myapp12

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class View3Activity : BaseActivity() {
    private val context: Context get() = this

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Visões
        setContentView(R.layout.activity_view3)
        val btLeave = findViewById<Button>(R.id.buttonLeave)

        //ativa o "up navigation" na actions bar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        btLeave.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
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
