package com.example.my_tut.register.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.my_tut.utils.UserSharedPreference
import com.example.my_tut.register.repository.RegistrationRepository
import com.example.my_tut.register.data.RegistrationModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch



/**

 * Created by Mina Roger on September,2020

 */

class RegistrationViewModel(application: Application) : AndroidViewModel(application) {
    var authFlag: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    private val repository =
        RegistrationRepository()
    fun register(user: RegistrationModel) {
        GlobalScope.launch(Dispatchers.IO) {
            val response = repository.register(user)
            if (response != null) {
                authFlag.postValue(true)
                UserSharedPreference(getApplication()).setToken(response.token)
            } else
                authFlag.postValue(false)
        }
    }
}
