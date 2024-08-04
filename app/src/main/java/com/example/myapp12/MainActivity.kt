package com.example.myapp12

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : BaseActivity() {
    private val context: Context get() = this
    //lateinit eu não preciso inicializar a classe
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        //pegando os temas e aplicando
        sharedPreferences = getSharedPreferences("app_prefs", MODE_PRIVATE)


        //Definindo a Visão
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //botoẽs view
        val btLogin = findViewById<Button>(R.id.buttonLogin)
        val btPassword = findViewById<Button>(R.id.buttonPassword)

        //botões tema
        val btMono = findViewById<Button>(R.id.buttonMono)
        val btTri = findViewById<Button>(R.id.buttonTri)
        val btQuad = findViewById<Button>(R.id.buttonQuad)


        //Eventos:
        btMono.setOnClickListener {
            changeTheme(0)
        }

        btTri.setOnClickListener {
            changeTheme(1)
        }

        btQuad.setOnClickListener {
            changeTheme(2)
        }

        btLogin.setOnClickListener {
            val tLogin = findViewById<TextView>(R.id.editTextTextEmailAddress)
            val tSenha = findViewById<TextView>(R.id.editTextNumberPassword)
            val login = tLogin.text.toString()
            val senha = tSenha.text.toString()

            if(login == "viviani" && senha == "1234") {
                val intent = Intent(context, BemVindoActivity::class.java)
                val params = Bundle()
                params.putString("nome", "Viviani")
                intent.putExtras(params)
                startActivity(intent)
            } else {
                toast("Login ou Senha incorretos!!")
            }
        }

        btPassword.setOnClickListener {
            val intent = Intent(context, PasswordRecoverActivity::class.java)
            startActivity(intent)
        }

    }

    private fun toast(s: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, s, length).show()
    }

    private fun changeTheme(theme: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt("theme", theme)
        editor.apply()
        // aplica tema e reinicia o app
        recreate()
    }

}
