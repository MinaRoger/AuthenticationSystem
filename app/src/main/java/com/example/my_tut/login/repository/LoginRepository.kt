package com.example.my_tut.login.repository

import com.example.my_tut.login.LoginAPI
import com.example.my_tut.login.data.LoginModel
import com.example.my_tut.login.data.LoginResponseModel
import com.example.my_tut.network.ApiClient

/**

 * Created by Mina Roger on September,2020

 */

class LoginRepository {
    private var apiService: LoginAPI? = null

    init {
        apiService = ApiClient.getApiClient().create(LoginAPI::class.java)
    }

    suspend fun login(user: LoginModel): LoginResponseModel? {
        return try {
            apiService?.login(user)
        } catch (ex: Exception) {
            null
        }

    }
}