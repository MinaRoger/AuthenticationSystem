package com.example.my_tut

import android.content.Context
import android.content.SharedPreferences


/**

 * Created by Mina Roger on September,2020

 */

class UserSharedPreference(context: Context?) {

    companion object {
        private const val AUTH = "AUTH"
        private const val TOKEN = "TOKEN"
    }

    private val sharedPref = context?.getSharedPreferences(AUTH, Context.MODE_PRIVATE)

    fun getToken() = sharedPref?.getString(TOKEN, "")
    fun setToken(token: String?) {
        sharedPref?.edit()?.putString(TOKEN, token)?.apply()
    }

}