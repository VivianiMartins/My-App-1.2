package com.example.myapp12

import android.os.Bundle
import android.annotation.SuppressLint
import android.content.Context
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class PasswordRecoverActivity : BaseActivity() {
    private val context: Context get() = this
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Visões
        setContentView(R.layout.activity_passord_recover)
        val btPassword = findViewById<Button>(R.id.buttonSave)

        //Eventos:
        btPassword.setOnClickListener {
            val tSenha = findViewById<TextView>(R.id.editTextNumberPassword)
            val tSenhaConfirm = findViewById<TextView>(R.id.editTextNumberPasswordConfirm)
            val senha = tSenha.text.toString()
            val senhaConfirm = tSenhaConfirm.text.toString()

            if(senha === senhaConfirm) {
                toast("Verifique seu e-mail")
            } else {
                toast("As senhas não são iguais!!")
            }
        }

        //ativa o "up navigation" na actions bar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            //Tratamos o clique no botão de voltar (<--)
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun toast(s: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, s, length).show()
    }
}