package com.example.my_tut

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.my_tut.login.ui.LoginActivity
import com.example.my_tut.register.ui.RegisterActivity

class WelcomeScreen : AppCompatActivity() {
    lateinit var loginBtn: Button
    lateinit var register: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen)
        loginBtn = findViewById(R.id.login)
        register = findViewById(R.id.register)
        loginBtn.setOnClickListener {
            navigateToLogin()
        }
        register.setOnClickListener {
            navigateToRegister()
        }
    }

    private fun navigateToLogin() {
        val homeIntent = Intent(this, LoginActivity::class.java)
        startActivity(homeIntent)
        finish()
    }

    private fun navigateToRegister() {
        val homeIntent = Intent(this, RegisterActivity::class.java)
        startActivity(homeIntent)
        finish()
    }
}