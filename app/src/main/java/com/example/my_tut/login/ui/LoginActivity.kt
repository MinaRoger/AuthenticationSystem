package com.example.my_tut.login.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.my_tut.MainActivity
import com.example.my_tut.R
import com.example.my_tut.login.data.LoginModel
import com.example.my_tut.login.viewmodel.LoginViewModel

@Suppress("DEPRECATION")
class LoginActivity : AppCompatActivity() {
    private lateinit var loginBtn: Button
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initializeComponents()
        loginBtn.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            loginViewModel.login(
                LoginModel(
                    username.text.toString(),
                    password.text.toString()
                )
            )
        }
        loginViewModel.authFlag.observe(this, Observer {
            progressBar.visibility = View.GONE
            if (it)
                navigateToHome()
            else
                showErrorMsg()
        })
    }

    private fun initializeComponents() {
        loginBtn = findViewById(R.id.login)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        progressBar = findViewById(R.id.loading)
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

    }

    private fun navigateToHome() {
        val homeIntent = Intent(this, MainActivity::class.java)
        startActivity(homeIntent)
        finish()
    }

    private fun showErrorMsg() {
        Toast.makeText(this, "Please Check your credentials", Toast.LENGTH_LONG).show()

    }

}
