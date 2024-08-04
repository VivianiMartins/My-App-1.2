package com.example.myapp12

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity


open class BaseActivity : ComponentActivity() {
    //lateinit eu não preciso inicializar a classe
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        //pegando os temas e aplicando
        sharedPreferences = getSharedPreferences("app_prefs", MODE_PRIVATE)
        val theme = sharedPreferences.getInt("theme", 0)
        setAppTheme(theme)
        super.onCreate(savedInstanceState)
    }

    private fun setAppTheme(theme: Int) {
        val themeResId = when (theme) {
            0 -> R.style.Theme_Mono
            1 -> R.style.Theme_Tri
            else -> R.style.Theme_Quad
        }
        setTheme(themeResId)
    }
}
