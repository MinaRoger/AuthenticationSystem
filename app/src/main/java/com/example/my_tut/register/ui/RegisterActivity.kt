package com.example.my_tut.register.ui

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
import com.example.my_tut.register.data.RegistrationModel
import com.example.my_tut.register.viewmodel.RegistrationViewModel


class RegisterActivity : AppCompatActivity() {
    lateinit var register: Button
    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var email: EditText
    lateinit var progressBar: ProgressBar
    private lateinit var registrationViewModel: RegistrationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initializeComponents()
        register.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            val user = RegistrationModel(
                email.text.toString(),
                username.text.toString(),
                password.text.toString()
            )
            registrationViewModel.register(user)
        }
        registrationViewModel.authFlag.observe(this, Observer {
            progressBar.visibility = View.GONE
            if (it) {
                navigateToHome()
            } else {
                showErrorMsg()
            }
        })

    }

    private fun initializeComponents() {
        register = findViewById(R.id.register)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        email = findViewById(R.id.email)
        progressBar = findViewById(R.id.loading)
        registrationViewModel =
            ViewModelProviders.of(this@RegisterActivity).get(RegistrationViewModel::class.java)


    }

    private fun navigateToHome() {
        val homeIntent = Intent(this, MainActivity::class.java)
        startActivity(homeIntent)
        finish()
    }

    private fun showErrorMsg() {
        Toast.makeText(this, "Wrong pw", Toast.LENGTH_LONG).show()

    }
}
