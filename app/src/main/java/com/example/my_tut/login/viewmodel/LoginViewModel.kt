package com.example.my_tut.login.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.my_tut.UserSharedPreference
import com.example.my_tut.login.repository.LoginRepository
import com.example.my_tut.login.data.LoginModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


/**

 * Created by Mina Roger on September,2020

 */

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val repository =
        LoginRepository()
    var authFlag: MutableLiveData<Boolean> = MutableLiveData<Boolean>()

    fun login(user: LoginModel) {
        GlobalScope.launch(Dispatchers.IO) {
            val res = repository.login(user)
            if (res != null) {
                UserSharedPreference(getApplication()).setToken(res.token)
                authFlag.postValue(true)
            } else
                authFlag.postValue(false)
        }
    }

}