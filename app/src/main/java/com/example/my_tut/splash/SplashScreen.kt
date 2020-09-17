package com.example.my_tut.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.example.my_tut.MainActivity
import com.example.my_tut.R
import com.example.my_tut.utils.UserSharedPreference
import com.example.my_tut.WelcomeScreen

class SplashScreen : AppCompatActivity() {
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            hideSystemUI()
        }
    }

    private fun hideSystemUI() {
        val decorView = window.decorView
        decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed({
            val token = UserSharedPreference(this).getToken()
            if (token.isNullOrEmpty())
                navigateToWelcomeScreen()
            else
                navigateToHome()
        }, SPLASH_TIMEOUT.toLong())
    }

    private fun navigateToWelcomeScreen() {
        val homeIntent = Intent(this@SplashScreen, WelcomeScreen::class.java)
        startActivity(homeIntent)
        finish()
    }

    private fun navigateToHome() {
        val homeIntent = Intent(this@SplashScreen, MainActivity::class.java)
        startActivity(homeIntent)
        finish()

    }

    companion object {
        private const val SPLASH_TIMEOUT = 2000
    }
}